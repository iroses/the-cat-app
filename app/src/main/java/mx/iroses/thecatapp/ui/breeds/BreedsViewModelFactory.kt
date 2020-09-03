package mx.iroses.thecatapp.ui.breeds

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import mx.iroses.thecatapp.data.source.BreedsRepository
import mx.iroses.thecatapp.data.source.remote.BreedsRemoteDataSource

class BreedsViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BreedsViewModel::class.java)) {
            return BreedsViewModel(BreedsRepository(BreedsRemoteDataSource())) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class $modelClass")
    }

}