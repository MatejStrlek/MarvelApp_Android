package hr.algebra.marvelapp.adapter

import android.content.ContentUris
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import hr.algebra.marvelapp.MARVEL_PROVIDER_CONTENT_URI
import hr.algebra.marvelapp.R
import hr.algebra.marvelapp.api.model.Character
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation
import java.io.File

class ItemAdapter (
    private val context: Context,
    private val items: MutableList<Character>
) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val ivItem = itemView.findViewById<ImageView>(R.id.ivItem)
        private val tvName = itemView.findViewById<TextView>(R.id.tvName)

        fun bind(character: Character) {
            tvName.text = character.name
            Picasso.get()
                .load(File(character.imagePath))
                .error(R.drawable.marvel)
                .transform(RoundedCornersTransformation(50, 5))
                .into(ivItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item, parent, false)
        )
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.itemView.setOnLongClickListener {
            context.contentResolver.delete(
                ContentUris.withAppendedId(MARVEL_PROVIDER_CONTENT_URI, item._id!!),
                null,
                null
            )

            File(item.imagePath).delete()
            items.removeAt(position)
            notifyDataSetChanged()

            true
        }
        holder.itemView.setOnClickListener {
            //edit
        }

        holder.bind(item)
    }
}