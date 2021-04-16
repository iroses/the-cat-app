package mx.iroses.thecatapp.ui.favorites

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import mx.iroses.thecatapp.data.Favorite
import mx.iroses.thecatapp.databinding.ItemFavoriteBinding

class FavoritesAdapter : RecyclerView.Adapter<FavoritesAdapter.ViewHolder>() {

    private val items = mutableListOf<Favorite>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(private val binding: ItemFavoriteBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(favorite: Favorite) {
            binding.image = favorite.image
            binding.executePendingBindings()
        }

        companion object {

            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemFavoriteBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    fun clear() {
        this.items.clear()
        notifyDataSetChanged()
    }

    fun addAll(items: MutableList<Favorite>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}