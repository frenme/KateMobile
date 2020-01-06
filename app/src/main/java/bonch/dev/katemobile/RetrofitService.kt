package bonch.dev.katemobile

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("/v2/everything")
    suspend fun getData(@Query("q") query: String, @Query("apiKey") apiKey: String): Response<NewsModel>

}