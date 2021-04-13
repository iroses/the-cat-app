package mx.iroses.thecatapp.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Breed(
    val id: String,
    val name: String,
    val description: String,
    val image: Image,
    val origin: String,
    val temperament: String,
    val weight: Weight,
    @SerializedName("life_span")
    val lifeSpan: String,
    @SerializedName("wikipedia_url")
    val wikipediaURL: String
) : Parcelable

@Parcelize
data class Weight(
    val imperial: String,
    val metric: String
) : Parcelable