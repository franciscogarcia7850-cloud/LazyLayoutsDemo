package com.example.lazylayoutsdemo.data

enum class TipoPlatillo { COMIDA, BEBIDA, POSTRE }

/** Modelo de datos de la lista horizontal. */
data class Platillo(
    val id: Int,
    val nombre: String,
    val tipo: TipoPlatillo
)
