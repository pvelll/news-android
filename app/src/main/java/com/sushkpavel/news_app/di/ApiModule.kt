package com.sushkpavel.news_app.di

import com.sushkpavel.data.remote.client.ClientFactory
import com.sushkpavel.data.remote.repository.NewsRepositoryImpl
import com.sushkpavel.domain.repository.NewsRepository
import com.sushkpavel.domain.usecase.news.GetNewsUseCase
import com.sushkpavel.domain.usecase.news.SearchNewsUseCase
import org.koin.dsl.module

val  apiModule = module {
    single {
        ClientFactory().build()
    }
    factory<NewsRepository>{
        NewsRepositoryImpl(get())
    }
    factory {
        GetNewsUseCase(get())
    }
    factory {
        SearchNewsUseCase(get())
    }
}