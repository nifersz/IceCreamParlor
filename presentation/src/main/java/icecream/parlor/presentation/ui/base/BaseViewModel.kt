package icecream.parlor.presentation.ui.base

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

abstract class BaseViewModel : ViewModel() {

    private val rxSubscriptions = CompositeDisposable()

    fun addRx(disposable: Disposable) {
        rxSubscriptions.add(disposable)
    }

    fun clearRx() {
        rxSubscriptions.clear()
    }

}