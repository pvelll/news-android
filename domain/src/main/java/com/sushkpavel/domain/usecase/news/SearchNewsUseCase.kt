package com.sushkpavel.domain.usecase.news

import com.sushkpavel.domain.repository.NewsRepository

class SearchNewsUseCase(
    private val repository: NewsRepository
) {
    suspend fun execute(q: String) =
        repository.getNews(
            country = null,
            category = null,
            query = q
        )
}