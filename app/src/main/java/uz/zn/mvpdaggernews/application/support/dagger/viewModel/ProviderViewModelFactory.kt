package uz.zn.mvpdaggernews.application.support.dagger.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class ProviderViewModelFactory @Inject internal constructor(
    private val providersMap: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val viewModel: ViewModel = providersMap[modelClass]?.get() ?:
        throw IllegalArgumentException("There is no provider registered for $modelClass")
        return viewModel as T
    }
}