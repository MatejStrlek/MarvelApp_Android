package hr.algebra.marvelapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import hr.algebra.marvelapp.framework.setBooleanPreference
import hr.algebra.marvelapp.framework.startActivity

class MarvelReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        context.setBooleanPreference(DATA_IMPORTED)
        context.startActivity<HostActivity>()
    }
}