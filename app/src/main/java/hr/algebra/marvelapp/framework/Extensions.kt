package hr.algebra.marvelapp.framework

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AnimationUtils
import androidx.core.content.getSystemService
import androidx.preference.PreferenceManager
import java.math.BigInteger
import java.security.MessageDigest

fun View.applyAnimation(animationId: Int) =
    startAnimation(AnimationUtils.loadAnimation(context, animationId))

inline fun <reified T : Activity> Context.startActivity() =
    startActivity(
        Intent(this, T::class.java)
        .apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        })

inline fun <reified T : BroadcastReceiver> Context.sendBroadcast() =
    sendBroadcast(Intent(this, T::class.java))

fun Context.setBooleanPreference(key: String, value: Boolean = true) =
    PreferenceManager.getDefaultSharedPreferences(this)
        .edit()
        .putBoolean(key, value)
        .apply()

fun Context.getBooleanPreference(key: String) =
    PreferenceManager.getDefaultSharedPreferences(this)
        .getBoolean(key, false)

fun callDelayed(delay: Long, action: () -> Unit) {
    Handler(Looper.getMainLooper()).postDelayed(
        action,
        delay
    )
}

fun Context.isOnline() : Boolean {
    val connectivityManager = getSystemService<ConnectivityManager>()

    connectivityManager?.activeNetwork?.let {network ->
        connectivityManager.getNetworkCapabilities(network)?.let {capabilities ->
            return capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
        }
    }

    return false
}

fun String.md5(): String =
    BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
        .toString(16).padStart(32, '0')