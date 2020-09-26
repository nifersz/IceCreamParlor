package icecream.parlor.presentation.mapper

import icecream.parlor.domain.model.IceCream
import icecream.parlor.presentation.model.UiIceCreamData

fun fromTheIceCreamsListToUi(inputList: List<IceCream>): List<UiIceCreamData> {
    val outputList = mutableListOf<UiIceCreamData>()
    if (inputList.isEmpty()) return outputList

    for (item in inputList) {
        outputList.add(
            UiIceCreamData(
                item.name,
                item.colorName,
                item.price,
                0,
                item.bgColor,
                item.type
            )
        )
    }
    return outputList
}