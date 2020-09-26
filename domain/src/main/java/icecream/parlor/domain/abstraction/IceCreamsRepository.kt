package icecream.parlor.domain.abstraction

import icecream.parlor.domain.model.IceCream
import io.reactivex.rxjava3.core.Single

interface IceCreamsRepository {
    fun getAll(): Single<List<IceCream>>
}