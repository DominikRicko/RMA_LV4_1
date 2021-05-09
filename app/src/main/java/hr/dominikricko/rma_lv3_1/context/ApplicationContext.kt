package hr.dominikricko.rma_lv3_1.context

import android.app.Application
import android.content.Context
import hr.dominikricko.rma_lv3_1.di.appModule
import hr.dominikricko.rma_lv3_1.di.viewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class ApplicationContext : Application() {

    companion object{
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = this

        startKoin{
            androidContext(this@ApplicationContext)
            modules(appModule, viewModel)
        }
    }
}