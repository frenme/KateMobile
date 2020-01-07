package bonch.dev.katemobile.adapters

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import bonch.dev.katemobile.R
import bonch.dev.katemobile.pojo.Video
import bonch.dev.katemobile.view.IVideosView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import io.github.luizgrp.sectionedrecyclerviewadapter.Section
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionParameters
import jp.wasabeef.glide.transformations.BlurTransformation

class VideosAdapter(
    private val title: String, private val list: ArrayList<Video>,
    private val iVideosView: IVideosView, val context: Context
) : Section(
    SectionParameters.builder()
        .itemResourceId(R.layout.video_item)
        .headerResourceId(R.layout.header_video_item)
        .build()
) {
    //open or close the section
    var isExpanded = true
    //test Image for video preview
    private val URL_PREVIEW: String = "https://redcher.ru/wp-content/uploads/2019/05/1046x616-video.png"


    override fun onBindItemViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemHolder = holder as ItemViewHolder
        itemHolder.titleItem.text = list[position].title

        Glide.with(context)
            .load(URL_PREVIEW)
            .apply(RequestOptions.bitmapTransform(BlurTransformation(5, 3)))
            .into(itemHolder.imgView)

        itemHolder.rootView.setOnClickListener {
            iVideosView.onItemRootViewClicked(
                title,
                itemHolder.adapterPosition
            )
        }
    }


    override fun onBindHeaderViewHolder(holder: RecyclerView.ViewHolder?) {
        val headerHolder = holder as HeaderViewHolder?

        headerHolder!!.titleSector.text = title
        //set arrow image according to open/close sector
        headerHolder.imgArrow.setImageResource(
            if (isExpanded) R.drawable.ic_arrow_up else R.drawable.ic_arrow_down
        )

        headerHolder.rootView.setOnClickListener {
            iVideosView.onHeaderRootViewClicked(
                this
            )
        }
    }


    //if section close, size = 0
    override fun getContentItemsTotal(): Int {
        return if (isExpanded) list.size else 0
    }


    override fun getItemViewHolder(view: View): RecyclerView.ViewHolder {
        return ItemViewHolder(view)
    }


    override fun getHeaderViewHolder(view: View): RecyclerView.ViewHolder {
        return HeaderViewHolder(view)
    }


    //for item of section
    internal class ItemViewHolder(val rootView: View) : RecyclerView.ViewHolder(rootView) {
        val titleItem: TextView = rootView.findViewById(R.id.titleItem)
        val imgView: ImageView = rootView.findViewById(R.id.imgItem)
    }


    //for header of section
    internal class HeaderViewHolder(val rootView: View) : RecyclerView.ViewHolder(rootView) {
        val titleSector: TextView = rootView.findViewById(R.id.titleSector)
        val imgArrow: ImageView = rootView.findViewById(R.id.imgArrow)
    }

}
