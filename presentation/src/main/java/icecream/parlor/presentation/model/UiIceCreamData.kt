package icecream.parlor.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UiIceCreamData(
    val title: String = ""
): Parcelable