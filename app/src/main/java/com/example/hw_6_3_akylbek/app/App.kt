package com.example.hw_6_3_akylbek.app

import android.app.Application
import com.example.hw_6_3_akylbek.data.module.dataModule
import com.example.hw_6_3_akylbek.ui.module.uiModule
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(dataModule, uiModule))
        }
    }
}