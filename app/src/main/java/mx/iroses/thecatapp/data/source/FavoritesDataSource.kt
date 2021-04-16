package mx.iroses.thecatapp.data.source

import mx.iroses.thecatapp.data.Favorite
import mx.iroses.thecatapp.data.Result

interface FavoritesDataSource {

    suspend fun loadFavorites(): Result<MutableList<Favorite>>
}