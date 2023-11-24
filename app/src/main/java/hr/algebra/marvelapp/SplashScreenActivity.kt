package hr.algebra.marvelapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import hr.algebra.marvelapp.databinding.ActivitySplashScreenBinding
import hr.algebra.marvelapp.framework.applyAnimation
import hr.algebra.marvelapp.framework.startActivity

private const val DELAY = 3000L

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
        Handler(Looper.getMainLooper()).postDelayed(
            { startActivity<HostActivity>() },
            DELAY
        )
    }
}