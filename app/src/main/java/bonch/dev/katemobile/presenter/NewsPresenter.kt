package bonch.dev.katemobile.presenter

import android.content.Context
import android.widget.Toast
import bonch.dev.katemobile.MainActivity.Companion.isInternet
import bonch.dev.katemobile.model.INewsModel
import bonch.dev.katemobile.model.NewsModel
import bonch.dev.katemobile.pojo.Articles
import bonch.dev.katemobile.view.INewsView


class NewsPresenter(val context: Context, val iNewsView: INewsView) : INewsPresenter {

    private var iNewsModel: INewsModel? = null

    override fun loadNews(query: String) {
        if (isInternet(context)) {
            iNewsModel!!.loadNews(query)
        } else {
            Toast.makeText(context, "Check your Internet connection", Toast.LENGTH_LONG).show()
        }
    }


    override fun setVideoRecyclerView(list: List<Articles>) {
        iNewsView.initRecyclerNews(list)
    }


    init {
        if (iNewsModel == null) {
            iNewsModel = NewsModel(this)
        }
    }
}