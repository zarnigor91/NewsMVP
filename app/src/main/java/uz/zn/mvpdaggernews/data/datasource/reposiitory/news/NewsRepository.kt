package uz.zn.mvpdaggernews.data.datasource.reposiitory.news

import io.reactivex.Observable
import uz.zn.mvpdaggernews.data.datasource.model.NewsListWrapper

interface NewsRepository {

    fun getAllNews() : Observable<NewsListWrapper>
}