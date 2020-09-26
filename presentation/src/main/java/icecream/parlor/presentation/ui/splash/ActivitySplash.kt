package icecream.parlor.presentation.ui.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import icecream.parlor.presentation.model.UiIceCreamData
import icecream.parlor.presentation.ui.main.ActivityMain

class ActivitySplash : AppCompatActivity() {

    private fun getTempList(): ArrayList<UiIceCreamData> {
        val list = arrayListOf<UiIceCreamData>()
        list.add(UiIceCreamData("Blue"))
        list.add(UiIceCreamData("Indigo"))
        list.add(UiIceCreamData("Teal"))
        list.add(UiIceCreamData("Green"))
        return list
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(ActivityMain.getStartIntent(this, getTempList()))
    }

}