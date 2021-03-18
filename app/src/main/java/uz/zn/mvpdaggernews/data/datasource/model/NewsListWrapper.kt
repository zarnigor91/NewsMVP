package uz.zn.mvpdaggernews.data.datasource.model

import uz.zn.mvpdaggernews.data.datasource.model.response.NewsItem

data class NewsListWrapper(val articles: List<NewsItem>, val isFromOfflineSource: Boolean)