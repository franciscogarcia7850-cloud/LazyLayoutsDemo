package com.example.lazylayoutsdemo.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BeachAccess
import androidx.compose.material.icons.filled.Cake
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocalBar
import androidx.compose.material.icons.filled.LocationCity
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.Terrain
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lazylayoutsdemo.data.Categoria
import com.example.lazylayoutsdemo.data.DatosDemo
import com.example.lazylayoutsdemo.data.Lugar
import com.example.lazylayoutsdemo.data.Platillo
import com.example.lazylayoutsdemo.data.TipoPlatillo
import com.example.lazylayoutsdemo.ui.theme.LazyLayoutsDemoTheme

/** Elemento de la LazyColumn. */
@Composable
fun LugarCard(
    lugar: Lugar,
    esFavorito: Boolean,
    onFavorito: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(12.dp)
        ) {
            Ilustracion(
                imagen = lugar.categoria.imagen(),
                fondo = MaterialTheme.colorScheme.primaryContainer,
                tinte = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier.size(64.dp)
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 12.dp)
            ) {
                Text(lugar.nombre, style = MaterialTheme.typography.titleMedium)
                Text(
                    text = lugar.descripcion,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            IconButton(onClick = onFavorito) {
                Icon(
                    imageVector = if (esFavorito) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription =
                        if (esFavorito) "Quitar ${lugar.nombre} de favoritos"
                        else "Agregar ${lugar.nombre} a favoritos",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

/** Elemento de la LazyRow. */
@Composable
fun PlatilloCard(platillo: Platillo, modifier: Modifier = Modifier) {
    Card(modifier = modifier.width(132.dp)) {
        Ilustracion(
            imagen = platillo.tipo.imagen(),
            fondo = MaterialTheme.colorScheme.tertiaryContainer,
            tinte = MaterialTheme.colorScheme.onTertiaryContainer,
            modifier = Modifier
                .fillMaxWidth()
                .height(84.dp)
        )
        Text(
            text = platillo.nombre,
            style = MaterialTheme.typography.labelLarge,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(12.dp)
        )
    }
}

@Composable
private fun Ilustracion(
    imagen: ImageVector,
    fondo: Color,
    tinte: Color,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(fondo)
    ) {
        // Decorativa: el nombre ya aparece como texto en la tarjeta
        Image(
            imageVector = imagen,
            contentDescription = null,
            colorFilter = ColorFilter.tint(tinte),
            modifier = Modifier.size(36.dp)
        )
    }
}

private fun Categoria.imagen(): ImageVector = when (this) {
    Categoria.PUEBLO -> Icons.Default.Home
    Categoria.PLAYA -> Icons.Default.BeachAccess
    Categoria.NATURALEZA -> Icons.Default.Terrain
    Categoria.CIUDAD -> Icons.Default.LocationCity
}

private fun TipoPlatillo.imagen(): ImageVector = when (this) {
    TipoPlatillo.COMIDA -> Icons.Default.Restaurant
    TipoPlatillo.BEBIDA -> Icons.Default.LocalBar
    TipoPlatillo.POSTRE -> Icons.Default.Cake
}

@Preview
@Composable
private fun LugarCardPreview() {
    LazyLayoutsDemoTheme(dynamicColor = false) {
        LugarCard(DatosDemo.lugares.first(), esFavorito = true, onFavorito = {})
    }
}
