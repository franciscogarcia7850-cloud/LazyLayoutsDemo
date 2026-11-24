package com.example.lazylayoutsdemo

import com.example.lazylayoutsdemo.data.DatosDemo
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class DatosDemoTest {

    @Test
    fun lasListasTienenEntre15Y20Elementos() {
        assertTrue(DatosDemo.lugares.size in 15..20)
        assertTrue(DatosDemo.platillos.size in 15..20)
    }

    @Test
    fun losIdsSonUnicos() {
        // Una key repetida hace que LazyColumn/LazyRow lancen una excepción
        assertEquals(DatosDemo.lugares.size, DatosDemo.lugares.map { it.id }.toSet().size)
        assertEquals(DatosDemo.platillos.size, DatosDemo.platillos.map { it.id }.toSet().size)
    }

    @Test
    fun dataClassComparaPorContenido() {
        val original = DatosDemo.lugares.first()
        assertEquals(original, original.copy())
        assertNotEquals(original, original.copy(nombre = "Otro"))
    }
}
