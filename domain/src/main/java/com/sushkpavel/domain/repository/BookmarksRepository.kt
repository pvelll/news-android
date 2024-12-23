package com.sushkpavel.domain.repository

import com.sushkpavel.domain.model.News
import kotlinx.coroutines.flow.Flow

interface BookmarksRepository {
    suspend fun addBookmark(news : News)
    suspend fun deleteBookmark(news: News)
    fun getBookmarks(): Flow<List<News>>
    fun isSaved(news: News): Flow<Boolean>
}