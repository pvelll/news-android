package com.sushkpavel.data.local.repository

import com.sushkpavel.data.local.dao.NewsDao
import com.sushkpavel.data.local.entity.toEntity
import com.sushkpavel.data.local.entity.toNews
import com.sushkpavel.domain.model.News
import com.sushkpavel.domain.repository.BookmarksRepository
import io.ktor.client.HttpClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class BookmarksRepositoryImpl(private val newsDao: NewsDao) : BookmarksRepository {
    override suspend fun addBookmark(news: News): Flow<Boolean> = flow {
        try {
            newsDao.insert(news.toEntity())
            emit(true)
        } catch (e: Exception) {
            emit(false)
        }
    }

    override suspend fun deleteBookmark(news: News): Flow<Boolean> = flow {
        try {
            newsDao.delete(news.toEntity())
            emit(true)
        } catch (e: Exception) {
            emit(false)
        }
    }


    override suspend fun getBookmarks(): Flow<List<News>> {
        return newsDao.getAll().map{ entities ->
            entities.map {
                it.toNews()
            }
        }
    }

    override suspend fun isSaved(news: News): Flow<Boolean> {
        return newsDao.isSaved(news.url)
    }
}