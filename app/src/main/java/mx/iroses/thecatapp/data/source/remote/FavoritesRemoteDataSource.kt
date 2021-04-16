package mx.iroses.thecatapp.data.source.remote

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import mx.iroses.thecatapp.BuildConfig
import mx.iroses.thecatapp.data.Favorite
import mx.iroses.thecatapp.data.Result
import mx.iroses.thecatapp.data.RetrofitService
import mx.iroses.thecatapp.data.source.FavoritesDataSource
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FavoritesRemoteDataSource : FavoritesDataSource {

    override suspend fun loadFavorites(): Result<MutableList<Favorite>> =
        withContext(Dispatchers.IO) {
            return@withContext try {

                val retrofit = Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                val service = retrofit.create(RetrofitService::class.java)

                val response = service.loadFavorites()

                Result.Success(response)

            } catch (exception: Exception) {
                Result.Error(exception)
            }
        }
}