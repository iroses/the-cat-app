package mx.iroses.thecatapp.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadCircularImage(url: String) {
    Glide.with(context)
        .load(url)
        .circleCrop()
        .thumbnail(0.1f)
        .into(this)
}

fun ImageView.loadImage(url: String) {
    Glide.with(context)
        .load(url)
        .thumbnail(0.1f)
        .into(this)
}