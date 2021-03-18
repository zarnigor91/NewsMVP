package uz.zn.mvpdaggernews.data.datasource.rest

import uz.zn.mvpdaggernews.data.datasource.rest.service.RestService

internal interface  RestProvider {
    val restService : RestService
}