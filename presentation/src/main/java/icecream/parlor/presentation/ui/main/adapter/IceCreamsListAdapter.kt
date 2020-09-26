package icecream.parlor.presentation.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import icecream.parlor.databinding.RvItemIcecreamBinding
import icecream.parlor.presentation.model.UiIceCreamData

class IceCreamsListAdapter : RecyclerView.Adapter<IceCreamViewHolder>() {

    private val itemsList = mutableListOf<UiIceCreamData>()

    override fun getItemCount() = itemsList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IceCreamViewHolder {
        return IceCreamViewHolder(
            RvItemIcecreamBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: IceCreamViewHolder, position: Int) {
        holder.bind(itemsList[position])
    }

    fun addAll(items: List<UiIceCreamData>) {
        itemsList.clear()
        itemsList.addAll(items)
        notifyDataSetChanged()
    }

}