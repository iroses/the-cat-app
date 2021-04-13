package mx.iroses.thecatapp.data

import retrofit2.http.GET

interface RetrofitService {

    @GET("breeds")
    suspend fun loadBreeds(): ArrayList<Breed>

    @GET("images/search?limit=21")
    suspend fun loadImages(): ArrayList<Image>
}