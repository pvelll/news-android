package com.sushkpavel.domain.usecase.bookmarks

import com.sushkpavel.domain.model.News
import com.sushkpavel.domain.repository.BookmarksRepository

class AddBookmarkUseCase(
    private val repository: BookmarksRepository
) {
    suspend fun execute(news: News) = repository.addBookmark(news)
}