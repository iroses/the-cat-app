package mx.iroses.thecatapp.ui.breeds

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import mx.iroses.thecatapp.utils.loadImage

@BindingAdapter("app:refreshing")
fun setRefreshing(swipeRefreshLayout: SwipeRefreshLayout, isRefreshing: Boolean?) {
    swipeRefreshLayout.isRefreshing = isRefreshing ?: false
}

@BindingAdapter("app:loadImage")
fun setLoadImage(imageView: ImageView, url: String?) {
    url?.let { imageView.loadImage(it) }
}