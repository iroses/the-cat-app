package mx.iroses.thecatapp.ui.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import mx.iroses.thecatapp.data.source.FavoritesRepository
import mx.iroses.thecatapp.data.source.remote.FavoritesRemoteDataSource

class FavoritesViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FavoritesViewModel::class.java)) {
            return FavoritesViewModel(FavoritesRepository(FavoritesRemoteDataSource())) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class $modelClass")
    }

    companion object {

        private var INSTANCE: FavoritesViewModelFactory? = null

        @JvmStatic
        fun getInstance(): FavoritesViewModelFactory {
            if (INSTANCE == null) {
                synchronized(FavoritesViewModelFactory::javaClass) {
                    INSTANCE = FavoritesViewModelFactory()
                }
            }
            return INSTANCE!!
        }
    }
}