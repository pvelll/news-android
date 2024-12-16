package com.sushkpavel.domain.usecase.bookmarks

import com.sushkpavel.domain.repository.BookmarksRepository

class GetBookmarksUseCase(
    private val repository: BookmarksRepository
) {
    suspend fun execute() = repository.getBookmarks()
}