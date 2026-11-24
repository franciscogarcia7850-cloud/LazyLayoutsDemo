package com.example.lazylayoutsdemo.data

enum class Categoria(val titulo: String) {
    PUEBLO("Pueblos mágicos"),
    PLAYA("Playas"),
    NATURALEZA("Naturaleza"),
    CIUDAD("Ciudades")
}

/**
 * Modelo de datos de la lista vertical.
 * El [id] es único y estable: se usa como `key` en la LazyColumn.
 */
data class Lugar(
    val id: Int,
    val nombre: String,
    val descripcion: String,
    val categoria: Categoria
)
