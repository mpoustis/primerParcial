package edu.uade.primerparcial.data

// Separo Pokemon y el repositorio en data porque ambos son "datos puros"
// Pokemon es solo un modelo, no sabe nada de pantallas ni logica
// Separando por responsabilidad, Pokemon.kt es solo el modelo y
// Solo cambia si el objeto Pokemon necesita un nuevo dato


data class Pokemon(
    val name: String,
    val url: String
) {
    val id: Int
        get() = url.trimEnd('/').substringAfterLast('/').toIntOrNull() ?: 0

    val spriteUrl: String
        get() = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"

    val nameFormatted: String
        get() = name.replaceFirstChar { it.uppercase() }
}
