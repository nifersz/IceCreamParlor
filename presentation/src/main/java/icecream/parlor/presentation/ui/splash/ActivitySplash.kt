package icecream.parlor.presentation.ui.splash

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import icecream.parlor.data.datasource.network.IceCreamsRetrofit
import icecream.parlor.data.datasource.network.RetrofitDefault
import icecream.parlor.data.repository.IceCreamsRepositoryImpl
import icecream.parlor.domain.usecase.impl.GetAllIceCreamsUseCase
import icecream.parlor.presentation.model.UiIceCreamData
import icecream.parlor.presentation.ui.main.ActivityMain

class ActivitySplash : AppCompatActivity() {

    //region Fields
    private val getAllIceCreamsUseCase = GetAllIceCreamsUseCase(
        IceCreamsRepositoryImpl(IceCreamsRetrofit(RetrofitDefault))
    )
    private val viewModel: SplashViewModel by viewModels {
        SplashViewModelFactory(getAllIceCreamsUseCase)
    }
    private val iceCreamsListObserver = Observer<List<UiIceCreamData>?> { listFound ->
        onIceCreamsListChanged(listFound)
    }
    //endregion

    //region Lifecycle Methods
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModelObserves()
    }

    override fun onStop() {
        viewModel.clearRx()
        super.onStop()
    }
    //endregion

    //region Private Methods
    private fun viewModelObserves() {
        viewModel.getList().observe(this, iceCreamsListObserver)
    }

    private fun onIceCreamsListChanged(listFound: List<UiIceCreamData>?) {
        if (listFound != null) {
            startActivity(ActivityMain.getStartIntent(this, ArrayList(listFound)))
        }
    }
    //endregion

}