package com.sushkpavel.news_app.di

import com.sushkpavel.news_app.presentation.screens.bookmarks.BookmarksViewModel
import com.sushkpavel.news_app.presentation.screens.details.NewsDetailsViewModel
import com.sushkpavel.news_app.presentation.screens.news.NewsViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule  = module {
    viewModel {
        NewsViewModel(get())
    }
    viewModel {
        NewsDetailsViewModel(get(),get(),get())
    }
    viewModel {
        BookmarksViewModel(get())
    }
}