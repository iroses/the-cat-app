package mx.iroses.thecatapp.utils

import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

@BindingAdapter("app:refreshing")
fun setRefreshing(swipeRefreshLayout: SwipeRefreshLayout, isRefreshing: Boolean?) {
    swipeRefreshLayout.isRefreshing = isRefreshing ?: false
}