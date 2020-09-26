package icecream.parlor.presentation.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import icecream.parlor.databinding.ActivityMainBinding
import icecream.parlor.presentation.model.UiIceCreamData
import icecream.parlor.presentation.ui.main.adapter.IceCreamsListAdapter

class ActivityMain : AppCompatActivity() {

    //region Fields
    private lateinit var rvIceCreamsList: RecyclerView
    private lateinit var rvAdapter: IceCreamsListAdapter
    //endregion

    //region Lifecycle Methods
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        prepareViewBindings()
    }
    //endregion

    //region Private Methods
    private fun prepareViewBindings() {
        val binding = ActivityMainBinding.inflate(layoutInflater)
        rvIceCreamsList = binding.recvIceCreamsList
        setContentView(binding.root)
        prepareViews()
    }

    private fun prepareViews() {
        rvAdapter = IceCreamsListAdapter()
        rvIceCreamsList.setHasFixedSize(true)
        rvIceCreamsList.layoutManager = LinearLayoutManager(this)
        rvIceCreamsList.adapter = rvAdapter
        rvIceCreamsList.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )
        if (intent.extras != null) {
            rvAdapter.addAll(intent.getParcelableArrayListExtra(ICE_CREAMS_LIST_UI_KEY)!!)
        }
    }
    //endregion

    companion object {
        private const val ICE_CREAMS_LIST_UI_KEY = "ICE_CREAMS_LIST_UI_KEY"

        fun getStartIntent(context: Context, data: ArrayList<UiIceCreamData>): Intent {
            val intent = Intent(context, ActivityMain::class.java)
            intent.putParcelableArrayListExtra(ICE_CREAMS_LIST_UI_KEY, data)
            return intent
        }

    }

}