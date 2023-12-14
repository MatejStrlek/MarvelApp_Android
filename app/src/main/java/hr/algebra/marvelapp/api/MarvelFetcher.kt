package hr.algebra.marvelapp.api

import android.content.Context
import hr.algebra.marvelapp.MarvelReceiver
import hr.algebra.marvelapp.framework.sendBroadcast

class MarvelFetcher(private val context: Context) {
    fun fetchItems(count: Int) {
        //fake work
        Thread.sleep(6000)
        //kad zavrsi baca broadcast
        context.sendBroadcast<MarvelReceiver>()
    }
}