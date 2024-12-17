package com.sushkpavel.data.local.repository

import com.sushkpavel.domain.model.News
import com.sushkpavel.domain.repository.BookmarksRepository
import io.ktor.client.HttpClient
import kotlinx.coroutines.flow.Flow

class BookmarksRepositoryImpl(client: HttpClient) : BookmarksRepository {
    override suspend fun addBookmark(news: News): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteBookmark(news: News): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getBookmarks(): Flow<List<News>> {
        TODO("Not yet implemented")
    }
}