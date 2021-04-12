package mx.iroses.thecatapp.data.source

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import mx.iroses.thecatapp.data.Breed
import mx.iroses.thecatapp.data.Result

class BreedsRepository(
    private val breedsRemoteDataSource: BreedsDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : BreedsDataSource {

    override suspend fun loadBreeds(): Result<ArrayList<Breed>> {
        return withContext(ioDispatcher) {
            return@withContext breedsRemoteDataSource.loadBreeds()
        }
    }
}