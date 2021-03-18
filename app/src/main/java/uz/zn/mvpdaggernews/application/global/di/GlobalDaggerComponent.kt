package uz.zn.mvpdaggernews.application.global.di

import dagger.Component
import uz.zn.mvpdaggernews.application.application.di.ApplicationDaggerComponent
import uz.zn.mvpdaggernews.application.global.GlobalActivity
import uz.zn.mvpdaggernews.application.global.navigation.GlobalNavigationController
import uz.zn.mvpdaggernews.data.datasource.reposiitory.RepositoryProvider

@GlobalScope
@Component(
    dependencies = [ApplicationDaggerComponent::class],
    modules = [
        GlobalDaggerModule::class,
        GlobalDaggerModules::class
    ]
)
interface GlobalDaggerComponent : RepositoryProvider {

      fun globalNavController(): GlobalNavigationController

      fun inject(activity: GlobalActivity)

      @Component.Factory
      interface Factory {
          fun create(component: ApplicationDaggerComponent): GlobalDaggerComponent
          }

    companion object {
        fun create(component: ApplicationDaggerComponent): GlobalDaggerComponent =
            DaggerGlobalDaggerComponent
                .factory()
                .create(component)
    }

}