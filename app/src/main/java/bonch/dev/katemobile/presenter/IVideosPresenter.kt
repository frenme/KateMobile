package bonch.dev.katemobile.presenter

import android.widget.LinearLayout
import bonch.dev.katemobile.pojo.Video

interface IVideosPresenter {
    fun loadVideos()
    fun setVideoRecyclerView(list: ArrayList<Video>)
    fun onItemViewClick(parentLayout: LinearLayout, itemPosition: Int, sectionTitle: String)
}