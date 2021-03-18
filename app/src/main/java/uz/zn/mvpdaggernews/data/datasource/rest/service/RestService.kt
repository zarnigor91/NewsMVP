package uz.zn.mvpdaggernews.data.datasource.rest.service

import io.reactivex.Single
import retrofit2.http.GET

internal interface RestService {
    @GET("topstories/v2/home.json?api-key=4rfwOLzLTWd1a5xixcPjwddAhw3p0eiF")
    fun fetchNews(): Single<NewsListResponse>
}