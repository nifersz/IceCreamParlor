package icecream.parlor.data.model

import com.google.gson.annotations.SerializedName

data class IceCreamResponse(
    @SerializedName("name1") val name: String? = null,
    @SerializedName("name2") val colorName: String? = null,
    @SerializedName("price") val price: String? = null,
    @SerializedName("bg_color") val bgColor: String? = null,
    @SerializedName("type") val type: String? = null
)