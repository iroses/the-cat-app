package mx.iroses.thecatapp.ui.gallery

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import mx.iroses.thecatapp.data.source.GalleryRepository
import mx.iroses.thecatapp.data.source.remote.GalleryRemoteDataSource

class GalleryViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GalleryViewModel::class.java)) {
            return GalleryViewModel(GalleryRepository(GalleryRemoteDataSource())) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class $modelClass")
    }

    companion object {

        private var INSTANCE: GalleryViewModelFactory? = null

        @JvmStatic
        fun getInstance(): GalleryViewModelFactory {
            if (INSTANCE == null) {
                synchronized(GalleryViewModelFactory::javaClass) {
                    INSTANCE = GalleryViewModelFactory()
                }
            }
            return INSTANCE!!
        }
    }
}