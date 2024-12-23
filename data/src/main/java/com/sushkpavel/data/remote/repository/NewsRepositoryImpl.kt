package com.sushkpavel.data.remote.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.sushkpavel.data.remote.paging.NewsPagingSource
import com.sushkpavel.domain.model.News
import com.sushkpavel.domain.repository.NewsRepository
import com.sushkpavel.data.utils.Utils.PAGE_SIZE
import io.ktor.client.HttpClient
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl(private val client: HttpClient) : NewsRepository {
    override suspend fun getNews(
        country: String?,
        query: String?,
        category: String?
    ): Flow<androidx.paging.PagingData<News>> = Pager(
        config =
        PagingConfig(
            pageSize = PAGE_SIZE,
            enablePlaceholders = false
        ),
        pagingSourceFactory = {
            NewsPagingSource(
                client = client,
                country = country,
                category = category,
                query= query
            )
        }
    ).flow
}