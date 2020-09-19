package mx.iroses.thecatapp.data

import com.google.gson.annotations.SerializedName

data class Breed(
    val name: String,
    val description: String,
    val image: Image,
    val origin: String,
    @SerializedName("wikipedia_url")
    val wikipediaURL: String
)

data class Image(
    val id: String,
    val width: Int,
    val height: Int,
    val url: String?
)