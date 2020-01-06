package bonch.dev.katemobile

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class NewsModel(
    @SerializedName("articles")
    @Expose
    val articles: List<ArticlesModel>
)

data class ArticlesModel(
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