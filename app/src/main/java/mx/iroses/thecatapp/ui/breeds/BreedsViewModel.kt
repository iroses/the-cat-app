package mx.iroses.thecatapp.ui.breeds

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mx.iroses.thecatapp.data.source.BreedsRepository

class BreedsViewModel(private val breedsRepository: BreedsRepository) : ViewModel() {

    fun loadBreeds() {
        viewModelScope.launch {
            val breedsResult = breedsRepository.loadBreeds()
        }
    }
}