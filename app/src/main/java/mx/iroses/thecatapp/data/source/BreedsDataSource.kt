package mx.iroses.thecatapp.data.source

import mx.iroses.thecatapp.data.Breed
import mx.iroses.thecatapp.data.Result

interface BreedsDataSource {

    suspend fun loadBreeds(): Result<ArrayList<Breed>>
}