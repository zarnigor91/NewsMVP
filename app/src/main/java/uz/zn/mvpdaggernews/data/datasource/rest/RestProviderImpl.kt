package uz.zn.mvpdaggernews.data.datasource.rest

import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import uz.zn.mvpdaggernews.data.datasource.rest.service.RestService
import uz.zn.mvpdaggernews.data.datasource.utils.Constants.Companion.BASE_URL
import uz.zn.mvpdaggernews.data.datasource.utils.Constants.Companion.TIMEOUT_SECONDS
import java.util.concurrent.TimeUnit

internal class RestProviderImpl :RestProvider{

    private val okHttpClientBuilder: OkHttpClient.Builder =
            OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor())
                    .retryOnConnectionFailure(false)
                    .followRedirects(false)
                    .followSslRedirects(false)
                    .connectTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
                    .readTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
                    .writeTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)

    private val retrofit: Retrofit by lazy {
        return@lazy Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClientBuilder.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    private companion object {
        const val CONNECTION_TIMEOUT_SECONDS: Long = 60
        const val API_BASE_URL: String = "https://newsapi.org/v2/"
    }

    override val restService: RestService =  retrofit.create(RestService::class.java)

}