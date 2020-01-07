package bonch.dev.katemobile.model

import bonch.dev.katemobile.pojo.Video

class VideosModel : IVideosModel {

    //here get data from DataBase or Net
    override fun loadVideos(): ArrayList<Video> {
        val list: ArrayList<Video> = arrayListOf()

        for (i in 0..10) {
            list.add(Video("Some video"))
        }

        return list
    }

}