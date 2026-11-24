package com.example.lazylayoutsdemo

// Modelo de datos
data class Lugar(
    val id: Int,
    val nombre: String,
    val descripcion: String
)

val lugares = listOf(
    Lugar(1, "Tequila", "Paisaje agavero"),
    Lugar(2, "Mazamitla", "Cabañas y bosque"),
    Lugar(3, "Tapalpa", "Calles empedradas"),
    Lugar(4, "San Sebastián del Oeste", "Antiguo pueblo minero"),
    Lugar(5, "Talpa de Allende", "Destino de peregrinación"),
    Lugar(6, "Puerto Vallarta", "Malecón y playa"),
    Lugar(7, "Yelapa", "Playa y cascada"),
    Lugar(8, "Barra de Navidad", "Laguna y playa"),
    Lugar(9, "Melaque", "Bahía tranquila"),
    Lugar(10, "Careyes", "Acantilados y playa"),
    Lugar(11, "Lago de Chapala", "El lago más grande de México"),
    Lugar(12, "Bosque La Primavera", "Aguas termales"),
    Lugar(13, "Nevado de Colima", "Montaña y bosque"),
    Lugar(14, "Barranca de Huentitán", "Cañón y senderos"),
    Lugar(15, "Sierra de Manantlán", "Reserva de la biósfera"),
    Lugar(16, "Guadalajara", "Capital del estado"),
    Lugar(17, "Zapopan", "Basílica de Zapopan"),
    Lugar(18, "Tonalá", "Artesanías"),
    Lugar(19, "Ameca", "Región Valles"),
    Lugar(20, "Ciudad Guzmán", "Zapotlán el Grande")
)
