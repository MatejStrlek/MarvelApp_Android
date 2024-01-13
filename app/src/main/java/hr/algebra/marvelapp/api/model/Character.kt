package hr.algebra.marvelapp.api.model

data class Character(
    val _id: Long?,
    val name: String,
    val imagePath: String,
    val comics: Int,
    val stories: Int,
    val events: Int,
    val series: Int
)
