package hr.algebra.marvelapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import hr.algebra.marvelapp.api.MarvelWorker
import hr.algebra.marvelapp.databinding.ActivitySplashScreenBinding
import hr.algebra.marvelapp.framework.applyAnimation
import hr.algebra.marvelapp.framework.callDelayed
import hr.algebra.marvelapp.framework.getBooleanPreference
import hr.algebra.marvelapp.framework.isOnline
import hr.algebra.marvelapp.framework.startActivity

private const val DELAY = 3500L

const val DATA_IMPORTED = "hr.algebra.marvelapp.data_imported"

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        startAnimations()
        redirect()
    }

    private fun startAnimations() {
        binding.ivSplash.applyAnimation(R.anim.left_to_right)
        binding.tvSplash.applyAnimation(R.anim.blink)
    }

    private fun redirect() {
        if (getBooleanPreference(DATA_IMPORTED)) {
            callDelayed(DELAY) { startActivity<HostActivity>() }
        }
        else {
            if (isOnline()) {
                WorkManager.getInstance(this).apply {
                    enqueueUniqueWork(
                        DATA_IMPORTED,
                        ExistingWorkPolicy.KEEP,
                        OneTimeWorkRequest.Companion.from(MarvelWorker::class.java)
                    )
                }
            }
            else {
                binding.tvSplash.text = getString(R.string.no_internet)
                callDelayed(DELAY) { finish() }
            }
        }
    }
}