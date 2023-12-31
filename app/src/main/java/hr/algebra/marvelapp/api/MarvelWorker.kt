package hr.algebra.marvelapp.api

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class MarvelWorker(
    private val context: Context,
    workerParams: WorkerParameters
    ) : Worker(context,  workerParams) {
    override fun doWork(): Result {
        MarvelFetcher(context).fetchItems()
        return Result.success()
    }
}