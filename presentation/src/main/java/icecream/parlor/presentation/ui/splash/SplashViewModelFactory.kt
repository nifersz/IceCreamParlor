package icecream.parlor.presentation.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import icecream.parlor.domain.usecase.GetAllIceCreams

class SplashViewModelFactory(
    private val getAllIceCreams: GetAllIceCreams
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(SplashViewModel::class.java)) {
            SplashViewModel(this.getAllIceCreams) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }

}