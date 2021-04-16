package mx.iroses.thecatapp.data

import retrofit2.http.GET
import retrofit2.http.Headers

interface RetrofitService {

    @GET("breeds")
    suspend fun loadBreeds(): ArrayList<Breed>

    @GET("images/search?limit=21")
    suspend fun loadImages(): ArrayList<Image>

    @Headers("x-api-key: a4eef134-83a8-4fab-8ad9-2c85556de18f")
    @GET("favourites")
    suspend fun loadFavorites(): MutableList<Favorite>
}