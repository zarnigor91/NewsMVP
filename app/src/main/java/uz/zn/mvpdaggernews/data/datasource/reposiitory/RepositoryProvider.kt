package uz.zn.mvpdaggernews.data.datasource.reposiitory

import uz.zn.mvpdaggernews.data.datasource.reposiitory.news.NewsRepository

interface RepositoryProvider {

    val newsRepository : NewsRepository
}