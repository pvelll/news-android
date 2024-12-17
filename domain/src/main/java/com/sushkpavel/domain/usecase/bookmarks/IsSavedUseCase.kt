package com.sushkpavel.domain.usecase.bookmarks

import com.sushkpavel.domain.model.News
import com.sushkpavel.domain.repository.BookmarksRepository

class IsSavedUseCase(
    private val bookmarksRepository: BookmarksRepository
) {
    suspend fun execute(news : News) = bookmarksRepository.isSaved(news)
}