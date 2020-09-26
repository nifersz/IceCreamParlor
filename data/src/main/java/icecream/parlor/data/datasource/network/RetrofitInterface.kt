package icecream.parlor.data.datasource.network

import retrofit2.Retrofit

interface RetrofitInterface {
    fun prepareTo(): Retrofit
}