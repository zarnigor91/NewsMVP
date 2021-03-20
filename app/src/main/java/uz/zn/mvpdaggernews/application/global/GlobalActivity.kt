package uz.zn.mvpdaggernews.application.global

import me.vponomarenko.injectionmanager.IHasComponent
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import uz.zn.mvpdaggernews.application.global.di.GlobalDaggerComponent
import uz.zn.mvpdaggernews.application.support.dagger.fragment.ProviderFragmentFactory
import javax.inject.Inject

class GlobalActivity : MvpAppCompatActivity(), IHasComponent<GlobalDaggerComponent>, GlobalView {

    @Inject
    @InjectPresenter
    lateinit var globalPresenter: GlobalPresenter

    @ProvidePresenter
    fun provideGlobalPresenter(): GlobalPresenter = globalPresenter

    @Inject
    fun setFragmentFactory(fragmentFactory: ProviderFragmentFactory){
         supportFragmentManager.fragmentFactory =fragmentFactory
    }

    private val binding by lazy {}

    override fun getComponent(): GlobalDaggerComponent {
        TODO("Not yet implemented")
    }

}