package icecream.parlor.presentation.ui.main.adapter

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import icecream.parlor.databinding.RvItemIcecreamBinding
import icecream.parlor.presentation.model.UiIceCreamData

class IceCreamViewHolder(binding: RvItemIcecreamBinding) : RecyclerView.ViewHolder(binding.root) {

    private val iceCreamTitle: TextView = binding.txtvIcecreamTitle

    fun bind(uiData: UiIceCreamData) {
        iceCreamTitle.text = uiData.title
    }

}