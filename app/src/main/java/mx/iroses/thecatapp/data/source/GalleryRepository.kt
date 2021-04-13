package mx.iroses.thecatapp.data.source

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import mx.iroses.thecatapp.data.Image
import mx.iroses.thecatapp.data.Result

class GalleryRepository(
    private val galleryRemoteDataSource: GalleryDataSource
) : GalleryDataSource {

    override suspend fun loadImages(): Result<ArrayList<Image>> {
        return withContext(Dispatchers.IO) {
            return@withContext galleryRemoteDataSource.loadImages()
        }
    }
}