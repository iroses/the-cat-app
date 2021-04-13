package mx.iroses.thecatapp.ui.breeds

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import mx.iroses.thecatapp.utils.loadCircularImage
import mx.iroses.thecatapp.utils.loadImage

@BindingAdapter("app:loadCircularImage")
fun setLoadCircularImage(imageView: ImageView, url: String?) {
    url?.let { imageView.loadCircularImage(it) }
}

@BindingAdapter("app:loadImage")
fun setLoadImage(imageView: ImageView, url: String?) {
    url?.let { imageView.loadImage(it) }
}
