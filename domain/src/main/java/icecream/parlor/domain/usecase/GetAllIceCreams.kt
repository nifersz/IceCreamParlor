package icecream.parlor.domain.usecase

import icecream.parlor.domain.model.IceCream
import io.reactivex.rxjava3.core.Single

interface GetAllIceCreams {
    fun execute(): Single<List<IceCream>>
}