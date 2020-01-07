package bonch.dev.katemobile.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import bonch.dev.katemobile.R
import bonch.dev.katemobile.pojo.Articles
import com.bumptech.glide.Glide


class NewsAdapter(val list: List<Articles>, val context: Context) : RecyclerView.Adapter<NewsAdapter.ItemPostHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemPostHolder {
        return ItemPostHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.news_item, parent, false)
        )
    }


    override fun getItemCount(): Int {
        return list.size
    }


    override fun onBindViewHolder(holder: ItemPostHolder, position: Int) {
        val post = list[position]
        holder.bind(post)
    }


    inner class ItemPostHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleNews = itemView.findViewById<TextView>(R.id.titleNews)
        private val imgNews = itemView.findViewById<ImageView>(R.id.imgNews)
        fun bind(post: Articles) {
            titleNews.text = post.title

            Glide.with(context)
                .load(post.urlToImage)
                .override(1000, 1000)
                .into(imgNews)
        }

    }

}
