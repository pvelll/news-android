package com.sushkpavel.domain.repository

import com.sushkpavel.domain.model.News
import kotlinx.coroutines.flow.Flow

interface BookmarksRepository {
    suspend fun addBookmark(news : News) : Boolean
    suspend fun deleteBookmark(news: News) : Boolean
    suspend fun getBookmarks(): Flow<List<News>>
}