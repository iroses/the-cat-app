package mx.iroses.thecatapp.data.source.remote

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import mx.iroses.thecatapp.data.Breed
import mx.iroses.thecatapp.data.Result
import mx.iroses.thecatapp.data.Result.Error
import mx.iroses.thecatapp.data.Result.Success
import mx.iroses.thecatapp.data.source.BreedsDataSource
import mx.iroses.thecatapp.utils.RetrofitFactory

class BreedsRemoteDataSource(
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : BreedsDataSource {

    override suspend fun loadBreeds(): Result<ArrayList<Breed>> = withContext(ioDispatcher) {
        return@withContext try {
            val response: ArrayList<Breed> = RetrofitFactory.makeRetrofitService().loadBreeds()
            Success(response)
        } catch (exception: Exception) {
            Error(exception)
        }
    }
}