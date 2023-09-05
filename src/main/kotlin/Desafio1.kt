package com.desafiolatam

import java.text.SimpleDateFormat
import java.util.*

/** Completa o modifica la clase Author, permitiendo almacenar
 *  Nombres
 *  Apellidos
 *  Obras destacadas
 *  Año de nacimiento
 *  Año de muerte (en caso de estar vivo, debe soportar valor nulo)
 *  Comentario
 */
data class Author(
    val name: String,
    val apellidos: String,
    val obrasDestacadas: String,
    val fechaDeNacimiento : String,
    val fechaDefuncion: String?,
    val comentario: String

)

/**
 * Calcula la edad basándose solamente en los año
 * Ejemplo: si nació en 1950 y estamos en 2022, entonces la edad es 72 años
 */
fun calculateAgeAlive (fechaDeNacimiento: String):Int {
    val formato = SimpleDateFormat("dd-MM-yyyy")
    try {
        val fechaNacimientoDate: Date = formato.parse(fechaDeNacimiento)
        val fechaActualDate = Date()
        val diferenciaEnMilisegundos = fechaActualDate.time - fechaNacimientoDate.time
        val edad = (diferenciaEnMilisegundos / (1000L * 60 * 60 * 24 * 365.25)).toInt()
        return edad
    } catch (e: Exception) {
        e.printStackTrace()
        return -1
    }
}
fun calculateAgeDead (fechaDeNacimiento: String, fechaDefuncion: String?): Int {
    val formato = SimpleDateFormat("dd-MM-yyyy")
    try {
        val fechaNacimientoDate: Date = formato.parse(fechaDeNacimiento)
        val fechaDefuncionDate: Date = formato.parse(fechaDefuncion)
        val diferenciaEnMilisegundos = fechaDefuncionDate.time - fechaNacimientoDate.time
        val edad = (diferenciaEnMilisegundos / (1000L * 60 * 60 * 24 * 365.25)).toInt()
        return edad
    } catch (e: Exception) {
        e.printStackTrace()
        return -1
    }
}
/**
 * No es necesario leer parámetros de entrada
 * la función "println" imprime en pantalla
 */

private fun showAuthor(autor: Author) {
    if (autor.fechaDefuncion != null){
        val deadAuthor = calculateAgeDead (autor.fechaDeNacimiento, autor.fechaDefuncion)
        println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
        println("+ Nombre del autor: ${autor.name} ${autor.apellidos}                +")
        println("+ Obras destacadas: " + autor.obrasDestacadas + "                   +")
        println("+ Año de nacimiento: " + autor.fechaDeNacimiento + "                           +")
        println("+ Comentario: " + autor.comentario + "        +")
        println("+ Año de muerte: " + autor.fechaDefuncion + ", murió a los años ${deadAuthor}          +")
        println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
    }else{
        val aliveAuthor = calculateAgeAlive(autor.fechaDeNacimiento)
        println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
        println("+ Nombre del autor: ${autor.name} ${autor.apellidos}                     +")
        println("+ Obras destacadas: " + autor.obrasDestacadas + "          +")
        println("+ Año de nacimiento: " + autor.fechaDeNacimiento + "                           +")
        println("+ Comentario: " + autor.comentario + "  +")
        println("+ El autor tiene ${aliveAuthor} años                                  +")
        println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
    }

}

fun main() {

    //ejemplo autor muerto
    val autorA = Author (
        "Gabriel",
        "García Marquéz",
        "100 años de Soledad",
        "06-03-1927",
        "17-04-2014",
        "Escritor nacido en Arataca, Colombia"
    )

    showAuthor(autorA)

    //ejemplo autor vivo
    val autorB = Author (
        "Quentin",
        "Tarantino",
        "Bastardos sin gloria, Django",
        "27-03-1963",
        null,
        "Director de cine, productor estadounidense"
    )

    showAuthor(autorB)

}


