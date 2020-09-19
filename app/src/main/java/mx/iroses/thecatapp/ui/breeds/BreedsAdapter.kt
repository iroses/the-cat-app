package mx.iroses.thecatapp.ui.breeds

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import mx.iroses.thecatapp.data.Breed
import mx.iroses.thecatapp.databinding.ItemBreedBinding

class BreedsAdapter : RecyclerView.Adapter<BreedsAdapter.ViewHolder>() {

    private val items = arrayListOf<Breed>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(private val binding: ItemBreedBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(breed: Breed) {
            binding.breed = breed
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemBreedBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    fun addAll(items: ArrayList<Breed>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}