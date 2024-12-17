package com.sushkpavel.domain.repository

import com.sushkpavel.domain.model.News
import kotlinx.coroutines.flow.Flow

interface BookmarksRepository {
    suspend fun addBookmark(news : News) : Flow<Boolean>
    suspend fun deleteBookmark(news: News) : Flow<Boolean>
    suspend fun getBookmarks(): Flow<List<News>>
    suspend fun isSaved(news: News): Flow<Boolean>
}