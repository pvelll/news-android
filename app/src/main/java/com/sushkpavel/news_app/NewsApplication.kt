package com.sushkpavel.news_app

import android.app.Application
import com.sushkpavel.news_app.di.apiModule
import com.sushkpavel.news_app.di.appModule
import com.sushkpavel.news_app.di.databaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NewsApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(listOf(appModule, apiModule, databaseModule))
        }
    }
}