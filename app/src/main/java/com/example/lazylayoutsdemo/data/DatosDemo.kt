package com.example.lazylayoutsdemo.data

object DatosDemo {

    /** 20 elementos para la LazyColumn. */
    val lugares: List<Lugar> = listOf(
        Lugar(1, "Tequila", "Paisaje agavero y destilerías.", Categoria.PUEBLO),
        Lugar(2, "Mazamitla", "Cabañas y bosque en la sierra.", Categoria.PUEBLO),
        Lugar(3, "Tapalpa", "Calles empedradas y Las Piedrotas.", Categoria.PUEBLO),
        Lugar(4, "San Sebastián del Oeste", "Antiguo pueblo minero.", Categoria.PUEBLO),
        Lugar(5, "Talpa de Allende", "Destino de peregrinación.", Categoria.PUEBLO),
        Lugar(6, "Puerto Vallarta", "Malecón y Bahía de Banderas.", Categoria.PLAYA),
        Lugar(7, "Yelapa", "Pueblo costero con cascada.", Categoria.PLAYA),
        Lugar(8, "Barra de Navidad", "Laguna y playa en la Costalegre.", Categoria.PLAYA),
        Lugar(9, "Melaque", "Bahía tranquila en Cihuatlán.", Categoria.PLAYA),
        Lugar(10, "Careyes", "Acantilados y casas de colores.", Categoria.PLAYA),
        Lugar(11, "Lago de Chapala", "El lago más grande de México.", Categoria.NATURALEZA),
        Lugar(12, "Bosque La Primavera", "Aguas termales y senderos.", Categoria.NATURALEZA),
        Lugar(13, "Nevado de Colima", "Montaña con bosque de pino.", Categoria.NATURALEZA),
        Lugar(14, "Barranca de Huentitán", "Cañón al norte de Guadalajara.", Categoria.NATURALEZA),
        Lugar(15, "Sierra de Manantlán", "Reserva de la biósfera.", Categoria.NATURALEZA),
        Lugar(16, "Guadalajara", "Capital del estado.", Categoria.CIUDAD),
        Lugar(17, "Zapopan", "Basílica y Andador 20 de Noviembre.", Categoria.CIUDAD),
        Lugar(18, "Tonalá", "Artesanías y tianguis.", Categoria.CIUDAD),
        Lugar(19, "Ameca", "Ciudad de la región Valles.", Categoria.CIUDAD),
        Lugar(20, "Ciudad Guzmán", "Cabecera de Zapotlán el Grande.", Categoria.CIUDAD)
    )

    /** 15 elementos para la LazyRow. */
    val platillos: List<Platillo> = listOf(
        Platillo(1, "Torta ahogada", TipoPlatillo.COMIDA),
        Platillo(2, "Birria", TipoPlatillo.COMIDA),
        Platillo(3, "Tejuino", TipoPlatillo.BEBIDA),
        Platillo(4, "Jericalla", TipoPlatillo.POSTRE),
        Platillo(5, "Carne en su jugo", TipoPlatillo.COMIDA),
        Platillo(6, "Cantarito", TipoPlatillo.BEBIDA),
        Platillo(7, "Cajeta de Sayula", TipoPlatillo.POSTRE),
        Platillo(8, "Pozole rojo", TipoPlatillo.COMIDA),
        Platillo(9, "Tequila", TipoPlatillo.BEBIDA),
        Platillo(10, "Alfajor de coco", TipoPlatillo.POSTRE),
        Platillo(11, "Enchiladas", TipoPlatillo.COMIDA),
        Platillo(12, "Raicilla", TipoPlatillo.BEBIDA),
        Platillo(13, "Charales", TipoPlatillo.COMIDA),
        Platillo(14, "Tepache", TipoPlatillo.BEBIDA),
        Platillo(15, "Rollo de guayaba", TipoPlatillo.POSTRE)
    )
}
