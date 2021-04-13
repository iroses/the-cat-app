package mx.iroses.thecatapp.data.source

import mx.iroses.thecatapp.data.Image
import mx.iroses.thecatapp.data.Result

interface GalleryDataSource {

    suspend fun loadImages(): Result<ArrayList<Image>>
}