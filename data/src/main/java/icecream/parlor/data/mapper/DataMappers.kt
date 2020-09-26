package icecream.parlor.data.mapper

import icecream.parlor.data.model.IceCreamResponse
import icecream.parlor.domain.model.IceCream

fun fromIceCreamListResponseToDomain(inputList: List<IceCreamResponse?>?): List<IceCream> {
    val outputList = mutableListOf<IceCream>()
    if (inputList == null || inputList.isEmpty())
        return outputList
    for (itemResponse in inputList) {
        itemResponse?.run {
            outputList.add(
                IceCream(
                    name ?: "",
                    colorName ?: "",
                    price ?: "",
                    bgColor ?: "",
                    type ?: "",
                )
            )
        }
    }
    return outputList
}