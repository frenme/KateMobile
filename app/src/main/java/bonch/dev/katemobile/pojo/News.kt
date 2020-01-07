package bonch.dev.katemobile.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class News(
    @SerializedName("articles")
    @Expose
    val articles: List<Articles>
)

data class Articles(
    @SerializedName("author")
    @Expose
    val author: String,

    @SerializedName("title")
    @Expose
    val title: String,

    @SerializedName("urlToImage")
    @Expose
    val urlToImage: String
)