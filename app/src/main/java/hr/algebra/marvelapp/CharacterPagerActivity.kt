package hr.algebra.marvelapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hr.algebra.marvelapp.adapter.ItemPagerAdapter
import hr.algebra.marvelapp.api.model.Character
import hr.algebra.marvelapp.databinding.ActivityCharacterPagerBinding
import hr.algebra.marvelapp.framework.fetchCharacters

const val POSITION = "hr.algebra.marvelapp.item_position"
class CharacterPagerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCharacterPagerBinding
    private lateinit var characters: MutableList<Character>

    private var position: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initPager()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initPager() {
        characters = fetchCharacters()
        position = intent.getIntExtra(POSITION, position)
        binding.viewPager.adapter = ItemPagerAdapter(this, characters)
        binding.viewPager.currentItem = position
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }
}