package hr.algebra.marvelapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hr.algebra.marvelapp.databinding.ActivityHostBinding

@Suppress("DEPRECATION")
class HostActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHostBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(
            android.R.anim.fade_in,
            android.R.anim.fade_out
        )
        binding = ActivityHostBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}