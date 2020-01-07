package bonch.dev.katemobile.view

import bonch.dev.katemobile.adapters.VideosAdapter
import bonch.dev.katemobile.pojo.Video

interface IVideosView{
    fun initialize()
    fun initRecyclerVideos(list: ArrayList<Video>)
    fun onHeaderRootViewClicked(section: VideosAdapter)
    fun onItemRootViewClicked(sectionTitle: String, itemAdapterPosition: Int)
}