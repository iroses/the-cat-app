package mx.iroses.thecatapp.ui.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mx.iroses.thecatapp.data.Favorite
import mx.iroses.thecatapp.data.Result
import mx.iroses.thecatapp.data.source.FavoritesRepository

class FavoritesViewModel(
    private val favoritesRepository: FavoritesRepository
) : ViewModel() {

    private val _dataLoading = MutableLiveData<Boolean>().apply { value = false }
    val dataLoading: LiveData<Boolean> = _dataLoading

    private val _items = MutableLiveData<MutableList<Favorite>>().apply { value = mutableListOf() }
    val items: LiveData<MutableList<Favorite>> = _items

    fun loadFavorites() {
        _dataLoading.value = true

        viewModelScope.launch {
            val loadFavoritesResponse = favoritesRepository.loadFavorites()

            _dataLoading.postValue(false)

            if (loadFavoritesResponse is Result.Success) {
                _items.postValue(loadFavoritesResponse.data)
            }
        }
    }
}