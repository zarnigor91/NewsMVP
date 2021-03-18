package uz.zn.mvpdaggernews.application.application.di

import dagger.Module
import dagger.Provides
import uz.zn.mvpdaggernews.data.datasource.reposiitory.RepositoryProvider
import uz.zn.mvpdaggernews.data.datasource.reposiitory.news.NewsRepository
import javax.inject.Singleton

object ApplicationDaggerModuleRepository {

    @Module
    object Provider{

        @JvmStatic
        @Provides
        @Singleton
        fun newsRepository(
            repositoryProvider: RepositoryProvider
        ): NewsRepository = repositoryProvider.newsRepository
    }


}