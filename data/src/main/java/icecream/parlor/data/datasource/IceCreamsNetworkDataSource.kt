package icecream.parlor.data.datasource

import icecream.parlor.domain.model.IceCream
import io.reactivex.rxjava3.core.Single

interface IceCreamsNetworkDataSource {
    fun getData(): Single<List<IceCream>>
}