package bonch.dev.katemobile.presenter

import bonch.dev.katemobile.pojo.Articles

interface INewsPresenter{
    fun loadNews(query: String)
    fun setVideoRecyclerView(list: List<Articles>)
}