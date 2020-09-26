package icecream.parlor.data.datasource.network

import icecream.parlor.data.api.ProductsApi
import icecream.parlor.data.datasource.IceCreamsNetworkDataSource
import icecream.parlor.data.mapper.fromIceCreamListResponseToDomain
import icecream.parlor.domain.model.IceCream
import io.reactivex.rxjava3.core.Single

class IceCreamsRetrofit(
    private val retrofit: RetrofitInterface
) : IceCreamsNetworkDataSource {

    override fun getData(): Single<List<IceCream>> = retrofit.prepareTo()
        .create(ProductsApi::class.java)
        .get()
        .map { response -> fromIceCreamListResponseToDomain(response) }

}