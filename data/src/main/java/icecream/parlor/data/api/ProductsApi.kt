package icecream.parlor.data.api

import icecream.parlor.data.model.IceCreamResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface ProductsApi {

    @GET("/products")
    fun get(): Single<List<IceCreamResponse?>?>

}