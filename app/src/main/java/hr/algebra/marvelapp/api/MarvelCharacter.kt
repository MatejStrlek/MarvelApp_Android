package hr.algebra.marvelapp.api

import kotlinx.serialization.Serializable

@Serializable
data class Thumbnail(val path: String, val extension: String)
@Serializable
data class ResourceList(val available: Int)
data class Comics(
    val available: Int,
    val collectionURI: String,
    val items: List<Any>,  // Adjust the type based on the actual structure
    val returned: Int
)
data class Series(
    val available: Int,
    val collectionURI: String,
    val items: List<Any>,  // Adjust the type based on the actual structure
    val returned: Int
)

data class Stories(
    val available: Int,
    val collectionURI: String,
    val items: List<Any>,  // Adjust the type based on the actual structure
    val returned: Int
)

data class Events(
    val available: Int,
    val collectionURI: String,
    val items: List<Any>,  // Adjust the type based on the actual structure
    val returned: Int
)
data class Url(
    val type: String,
    val url: String
)

data class MarvelCharacter(
    val id: Long,
    val name: String,
    val description: String,
    val modified: String,
    val thumbnail: Thumbnail,
    val resourceURI: String,
    val comics: Comics,
    val series: Series,
    val stories: Stories,
    val events: Events,
    val urls: List<Url>
)
