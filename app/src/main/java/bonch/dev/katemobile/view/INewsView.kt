package bonch.dev.katemobile.view

import bonch.dev.katemobile.pojo.Articles

interface INewsView {
    fun initRecyclerNews(list: List<Articles>)
}