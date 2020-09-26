package icecream.parlor.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UiIceCreamData(
    val name: String = "",
    val colorName: String = "",
    val price: String = "",
    val quantity: Int = 0,
    val bgColor: String = "",
    val type: String = ""
): Parcelable