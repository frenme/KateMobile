package bonch.dev.katemobile.model

import bonch.dev.katemobile.pojo.Video

interface IVideosModel {
    fun loadVideos(): ArrayList<Video>
}