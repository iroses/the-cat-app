package mx.iroses.thecatapp.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Image(
    val id: String,
    val width: Int,
    val height: Int,
    val url: String?
) : Parcelable