package com.sushkpavel.domain.usecase.news

import com.sushkpavel.domain.repository.NewsRepository

class GetNewsUseCase (
    private val repository: NewsRepository
) {
    suspend fun execute(
        country: String? = "",
        category: String?
    ) = repository.getNews(
        country = country,
        category = category,
        query = null
    )
}