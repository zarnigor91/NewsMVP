package uz.zn.mvpdaggernews.data.datasource.reposiitory.news

import io.reactivex.Observable
import uz.zn.mvpdaggernews.data.datasource.model.NewsListWrapper
import uz.zn.mvpdaggernews.data.datasource.rest.service.RestService

internal class NewsRepositoryImpl(
    private val restService: RestService
) : NewsRepository{
    override fun getAllNews(): Observable<NewsListWrapper> {
        TODO("Not yet implemented")
    }
}