package uz.zn.mvpdaggernews.application.application

import android.app.Application
import android.content.Context
import com.facebook.drawee.backends.pipeline.Fresco
import me.vponomarenko.injectionmanager.IHasComponent
import me.vponomarenko.injectionmanager.x.XInjectionManager
import uz.zn.mvpdaggernews.application.application.di.ApplicationDaggerComponent
import kotlin.properties.Delegates

class Application : Application(),
    IHasComponent<ApplicationDaggerComponent> {

    private var appContext : Context by Delegates.notNull()

    override fun getComponent(): ApplicationDaggerComponent =
        ApplicationDaggerComponent.create(appContext)

    override fun attachBaseContext(base: Context?) {
        if (base != null) {
            appContext = base
        }
        XInjectionManager.let { it.init(this); it.bindComponent(this).inject(this) }
        super.attachBaseContext(base)

    }

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }
}