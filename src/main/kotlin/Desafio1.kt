package com.desafiolatam

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
)

/**
 * Calcula la edad basándose solamente en los año
 * Ejemplo: si nació en 1950 y estamos en 2022, entonces la edad es 72 años
 */
fun calculateAge() {

}

/**
 * No es necesario leer parámetros de entrada
 * la función "println" imprime en pantalla
 */
fun main() {
    println("*********************")
}
