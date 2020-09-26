package icecream.parlor.presentation.ui.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import icecream.parlor.domain.usecase.GetAllIceCreams
import icecream.parlor.presentation.mapper.fromTheIceCreamsListToUi
import icecream.parlor.presentation.model.UiIceCreamData
import icecream.parlor.presentation.ui.base.BaseViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class SplashViewModel(
    private val getAllIceCreams: GetAllIceCreams
) : BaseViewModel() {

    private val list = MutableLiveData<List<UiIceCreamData>>()

    private fun loadGrid() {
        addRx(getAllIceCreams.execute()
            .map { fromTheIceCreamsListToUi(it) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { emittedResult -> list.value = emittedResult })
    }

    fun getList(): LiveData<List<UiIceCreamData>> {
        if (list.value == null) loadGrid()
        return list
    }

}