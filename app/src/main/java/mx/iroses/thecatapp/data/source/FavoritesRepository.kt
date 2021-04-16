package mx.iroses.thecatapp.data.source

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import mx.iroses.thecatapp.data.Favorite
import mx.iroses.thecatapp.data.Result

class FavoritesRepository(
    private val favoritesRemoteDataSource: FavoritesDataSource
) : FavoritesDataSource {

    override suspend fun loadFavorites(): Result<MutableList<Favorite>> {
        return withContext(Dispatchers.IO) {
            return@withContext favoritesRemoteDataSource.loadFavorites()
        }
    }
}