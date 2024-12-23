package com.sushkpavel.domain.repository

import androidx.paging.PagingData
import com.sushkpavel.domain.model.News
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    suspend fun getNews(
        country : String?,
        query : String?,
        category : String?
    ): Flow<PagingData<News>>
}