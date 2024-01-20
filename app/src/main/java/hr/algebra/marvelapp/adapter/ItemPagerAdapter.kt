package hr.algebra.marvelapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import hr.algebra.marvelapp.R
import hr.algebra.marvelapp.api.model.Character
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation
import java.io.File

class ItemPagerAdapter (
    private val context: Context,
    private val items: MutableList<Character>
) : RecyclerView.Adapter<ItemPagerAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val ivItem = itemView.findViewById<ImageView>(R.id.ivImage)

        private val tvName = itemView.findViewById<TextView>(R.id.tvName)
        private val tvNumComics = itemView.findViewById<TextView>(R.id.tvNumComics)
        private val tvNumStories = itemView.findViewById<TextView>(R.id.tvNumStories)
        private val tvNumEvents = itemView.findViewById<TextView>(R.id.tvNumEvents)
        private val tvNumSeries = itemView.findViewById<TextView>(R.id.tvNumSeries)

        fun bind(character: Character) {
            tvName.text = character.name
            tvNumComics.text = character.comics.toString()
            tvNumStories.text = character.stories.toString()
            tvNumEvents.text = character.events.toString()
            tvNumSeries.text = character.series.toString()

            Picasso.get()
                .load(File(character.imagePath))
                .error(R.drawable.marvel)
                .transform(RoundedCornersTransformation(50, 5))
                .into(ivItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_pager, parent, false)
        )
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }
}