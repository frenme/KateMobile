package bonch.dev.katemobile.model

import android.util.Log
import bonch.dev.katemobile.RetrofitService
import bonch.dev.katemobile.pojo.Articles
import bonch.dev.katemobile.pojo.News
import bonch.dev.katemobile.presenter.INewsPresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsModel(val iNewsPresenter: INewsPresenter) : INewsModel {

    private val API_KEY = "2538d74de2a040b28dfb0b3f7bc5947c"

    override fun loadNews(query: String){
        var response: Response<News>
        val service = makeRetrofitService()
        var list: List<Articles>

        CoroutineScope(Dispatchers.IO).launch {
            //send request and get data object
            response = service.getData(query, API_KEY)
            try {
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        //get list data and init recycler
                        list = response.body()!!.articles
                        iNewsPresenter.setVideoRecyclerView(list)
                    }
                }
            } catch (err: HttpException) {
                Log.e("Retrofit", "${err.printStackTrace()}")
            }
        }
    }


    companion object {
        private val BASE_URL = "https://newsapi.org"

        private fun makeRetrofitService(): RetrofitService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(RetrofitService::class.java)
        }
    }

}