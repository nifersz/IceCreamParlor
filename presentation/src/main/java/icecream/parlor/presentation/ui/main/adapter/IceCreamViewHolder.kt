package icecream.parlor.presentation.ui.main.adapter

import android.content.Context
import android.content.res.ColorStateList
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import icecream.parlor.R
import icecream.parlor.databinding.RvItemIcecreamBinding
import icecream.parlor.presentation.model.UiIceCreamData

class IceCreamViewHolder(binding: RvItemIcecreamBinding) : RecyclerView.ViewHolder(binding.root) {

    private val iceCreamImgHolder: FrameLayout = binding.flayIcecreamImgHolder
    private val iceCreamIcon: ImageView = binding.imgvIcecreamIcon
    private val iceCreamName: TextView = binding.txtvIcecreamName
    private val iceCreamPrice: TextView = binding.txtvIcecreamPrice

    fun bind(uiData: UiIceCreamData) {
        val drawableName = when (uiData.type) {
            "cone" -> "cone"
            "froyo" -> "froyo"
            "popsicle" -> "popsicle"
            else -> "ice_cream"
        }
        loadAnImage(drawableName)
        iceCreamName.text = uiData.name + " " + uiData.colorName
        iceCreamPrice.text = uiData.price
        iceCreamImgHolder.backgroundTintList = colorForBgTintList(R.color.color2, itemView.context)
    }

    private fun loadAnImage(url: String) {
        Glide.with(itemView)
            .load(getImage(url))
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(iceCreamIcon)
    }

    private fun getImage(imageName: String): Int {
        return itemView.resources.getIdentifier(
            imageName, "drawable", itemView.context.packageName
        )
    }

    private fun colorForBgTintList(colorRes: Int, context: Context): ColorStateList {
        return ColorStateList.valueOf(ContextCompat.getColor(context, colorRes))
    }

}