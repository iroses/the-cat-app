package mx.iroses.thecatapp.ui.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import mx.iroses.thecatapp.data.Image
import mx.iroses.thecatapp.databinding.ItemGalleryImageBinding

class GalleryAdapter : RecyclerView.Adapter<GalleryAdapter.ViewHolder>() {

    private val items = arrayListOf<Image>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(private val binding: ItemGalleryImageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(image: Image) {
            binding.image = image
            binding.executePendingBindings()
        }

        companion object {

            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemGalleryImageBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    fun clear() {
        this.items.clear()
        notifyDataSetChanged()
    }

    fun addAll(items: ArrayList<Image>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}