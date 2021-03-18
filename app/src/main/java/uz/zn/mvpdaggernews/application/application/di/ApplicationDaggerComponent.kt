package uz.zn.mvpdaggernews.application.application.di

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import uz.zn.mvpdaggernews.data.datasource.reposiitory.RepositoryProvider
import javax.inject.Singleton


@Singleton
@Component (modules = [ApplicationDaggerModule::class, ApplicationDaggerModuleRepository::class])
interface ApplicationDaggerComponent : RepositoryProvider {

    fun inject(application: Application)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationDaggerComponent
    }

     companion object{
         fun create(context: Context): ApplicationDaggerComponent =
                 DaggerApplicationDaggerComponent.factory().create(context)
     }

}
