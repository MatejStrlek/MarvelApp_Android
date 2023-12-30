package hr.algebra.marvelapp.handler

import android.content.Context
import android.util.Log
import hr.algebra.marvelapp.factory.createGetHttpConnection
import java.io.File
import java.net.HttpURLConnection
import java.nio.file.Files
import java.nio.file.Paths

fun downloadImageAndStore(context : Context, path : String, extension : String) : String? {
    val fileName = path.substring(path.lastIndexOf(File.separatorChar) + 1)
    val file: File = createFile(context, fileName, extension)

    try {
        val con: HttpURLConnection = createGetHttpConnection(path, extension)
        Files.copy(con.inputStream, Paths.get(file.toURI()))
        return file.absolutePath
    } catch (e: Exception) {
        Log.e("IMAGES_HANDLER", e.toString(), e)
    }

    return null
}

fun createFile(context: Context, fileName: String, extension: String): File {
    val dir = context.applicationContext.getExternalFilesDir(null)
    val file = File(dir, "$fileName.$extension")
    if (file.exists()) file.delete()
    return file
}
