package mx.iroses.thecatapp.ui.breeds

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mx.iroses.thecatapp.data.Breed
import mx.iroses.thecatapp.data.Result
import mx.iroses.thecatapp.data.source.BreedsRepository

class BreedsViewModel(
    private val breedsRepository: BreedsRepository
) : ViewModel() {

    private val _dataLoading = MutableLiveData<Boolean>()
    val dataLoading: LiveData<Boolean> = _dataLoading

    private val _items = MutableLiveData<ArrayList<Breed>>().apply { value = arrayListOf() }
    val items: LiveData<ArrayList<Breed>> = _items

    fun loadBreeds() {
        _dataLoading.value = true

        viewModelScope.launch {
            val breedsResult = breedsRepository.loadBreeds()

            _dataLoading.value = false

            if (breedsResult is Result.Success) {
                _items.postValue(breedsResult.data)
            }
        }
    }
}