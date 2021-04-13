package mx.iroses.thecatapp.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mx.iroses.thecatapp.data.Image
import mx.iroses.thecatapp.data.Result
import mx.iroses.thecatapp.data.source.GalleryRepository

class GalleryViewModel(
    private val galleryRepository: GalleryRepository
) : ViewModel() {

    private val _dataLoading = MutableLiveData<Boolean>().apply { value = false }
    val dataLoading: LiveData<Boolean> = _dataLoading

    private val _items = MutableLiveData<ArrayList<Image>>().apply { value = arrayListOf() }
    val items: LiveData<ArrayList<Image>> = _items

    fun loadImages() {
        _dataLoading.value = true

        viewModelScope.launch {
            val loadImagesResponse = galleryRepository.loadImages()

            _dataLoading.postValue(false)

            if (loadImagesResponse is Result.Success) {
                _items.postValue(loadImagesResponse.data)
            }
        }
    }
}