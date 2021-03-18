package uz.zn.mvpdaggernews.data.datasource.model.response

import com.google.gson.annotations.SerializedName


data class NewsListResponse(
    @SerializedName("results")
    val results: List<NewsItem>
)