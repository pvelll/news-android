package com.sushkpavel.news_app.di

import android.content.Context
import androidx.room.Room
import com.sushkpavel.data.local.db.NewsDB
import com.sushkpavel.data.local.repository.BookmarksRepositoryImpl
import com.sushkpavel.data.utils.Utils.DATABASE_NAME
import com.sushkpavel.domain.repository.BookmarksRepository
import com.sushkpavel.domain.usecase.bookmarks.AddBookmarkUseCase
import com.sushkpavel.domain.usecase.bookmarks.DeleteBookmarkUseCase
import com.sushkpavel.domain.usecase.bookmarks.GetBookmarksUseCase
import com.sushkpavel.domain.usecase.bookmarks.IsSavedUseCase
import org.koin.dsl.module

val databaseModule = module{

    single {
        Room.databaseBuilder(
            get<Context>(),
            NewsDB::class.java,
            DATABASE_NAME
        ).build()
    }

    single { get<NewsDB>().newsDao() }

    factory<BookmarksRepository> {
        BookmarksRepositoryImpl(get())
    }

    factory<GetBookmarksUseCase>{
        GetBookmarksUseCase(get())
    }
    factory<IsSavedUseCase> {
        IsSavedUseCase(get())
    }
    factory<AddBookmarkUseCase>{
        AddBookmarkUseCase(get())
    }
    factory<DeleteBookmarkUseCase>{
        DeleteBookmarkUseCase(get())
    }
}