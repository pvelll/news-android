package com.sushkpavel.news_app.di

import androidx.room.Room
import com.sushkpavel.data.local.db.NewsDB
import com.sushkpavel.data.local.repository.BookmarksRepositoryImpl
import com.sushkpavel.data.utils.Utils.BOOKMARKS_TABLE_NAME
import com.sushkpavel.domain.repository.BookmarksRepository
import org.koin.dsl.module

val databaseModule = module{

    single {
        Room.databaseBuilder(
            get(),
            NewsDB::class.java,
            BOOKMARKS_TABLE_NAME
        ).build()
    }

    single { get<NewsDB>().newsDao() }

    factory<BookmarksRepository> {
        BookmarksRepositoryImpl(get())
    }
}