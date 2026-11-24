package com.example.lazylayoutsdemo.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lazylayoutsdemo.data.Categoria
import com.example.lazylayoutsdemo.data.DatosDemo
import com.example.lazylayoutsdemo.data.Platillo
import com.example.lazylayoutsdemo.ui.theme.LazyLayoutsDemoTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaListas() {
    // null significa "todas las categorías"
    var filtro by rememberSaveable { mutableStateOf<Categoria?>(null) }
    var favoritos by rememberSaveable { mutableStateOf(setOf<Int>()) }

    val estadoLista = rememberLazyListState()
    val scope = rememberCoroutineScope()

    // Solo provoca recomposición cuando cambia el resultado, no en cada píxel de scroll
    val mostrarBotonSubir by remember {
        derivedStateOf { estadoLista.firstVisibleItemIndex > 2 }
    }

    // Se recalcula únicamente al cambiar el filtro
    val lugaresPorCategoria = remember(filtro) {
        DatosDemo.lugares
            .filter { filtro == null || it.categoria == filtro }
            .groupBy { it.categoria }
    }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Descubre Jalisco") }) },
        floatingActionButton = {
            AnimatedVisibility(visible = mostrarBotonSubir) {
                FloatingActionButton(
                    onClick = { scope.launch { estadoLista.animateScrollToItem(0) } }
                ) {
                    Icon(Icons.Default.KeyboardArrowUp, contentDescription = "Volver arriba")
                }
            }
        }
    ) { innerPadding ->
        LazyColumn(
            state = estadoLista,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = innerPadding.calculateTopPadding()),
            // El espacio inferior se desplaza con la lista y deja libre el botón flotante
            contentPadding = PaddingValues(bottom = innerPadding.calculateBottomPadding() + 88.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item(key = "titulo-platillos", contentType = "titulo") {
                Titulo("Sabores de Jalisco")
            }
            item(key = "platillos", contentType = "fila") {
                FilaPlatillos(DatosDemo.platillos)
            }
            item(key = "titulo-lugares", contentType = "titulo") {
                Titulo("Lugares para visitar")
            }
            item(key = "filtros", contentType = "fila") {
                FilaFiltros(seleccionado = filtro, onSeleccionar = { filtro = it })
            }

            lugaresPorCategoria.forEach { (categoria, lugares) ->
                stickyHeader(key = "encabezado-${categoria.name}", contentType = "encabezado") {
                    Encabezado("${categoria.titulo} (${lugares.size})")
                }
                items(
                    items = lugares,
                    key = { it.id },
                    contentType = { "lugar" }
                ) { lugar ->
                    LugarCard(
                        lugar = lugar,
                        esFavorito = lugar.id in favoritos,
                        onFavorito = {
                            favoritos =
                                if (lugar.id in favoritos) favoritos - lugar.id
                                else favoritos + lugar.id
                        },
                        modifier = Modifier
                            .animateItem()
                            .padding(horizontal = 16.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun FilaPlatillos(platillos: List<Platillo>) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(items = platillos, key = { it.id }) { platillo ->
            PlatilloCard(platillo)
        }
    }
}

@Composable
private fun FilaFiltros(
    seleccionado: Categoria?,
    onSeleccionar: (Categoria?) -> Unit
) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item(key = "todos") {
            FilterChip(
                selected = seleccionado == null,
                onClick = { onSeleccionar(null) },
                label = { Text("Todos") }
            )
        }
        items(items = Categoria.entries, key = { it.name }) { categoria ->
            FilterChip(
                selected = seleccionado == categoria,
                onClick = { onSeleccionar(categoria) },
                label = { Text(categoria.titulo) }
            )
        }
    }
}

@Composable
private fun Titulo(texto: String) {
    Text(
        text = texto,
        style = MaterialTheme.typography.titleLarge,
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp)
    )
}

@Composable
private fun Encabezado(texto: String) {
    // Fondo opaco para que las tarjetas no se vean detrás al quedar fijo
    Surface(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = texto,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PantallaListasPreview() {
    LazyLayoutsDemoTheme(dynamicColor = false) {
        PantallaListas()
    }
}
