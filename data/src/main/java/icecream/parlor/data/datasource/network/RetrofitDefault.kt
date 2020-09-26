package icecream.parlor.data.datasource.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitDefault : RetrofitInterface {

    override fun prepareTo(): Retrofit {
        return Retrofit.Builder()
            .client(createHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .baseUrl("https://gl-endpoint.herokuapp.com")
            .build()
    }

    private fun createHttpClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.connectTimeout(50, TimeUnit.SECONDS)
        return httpClient.build()
    }

}