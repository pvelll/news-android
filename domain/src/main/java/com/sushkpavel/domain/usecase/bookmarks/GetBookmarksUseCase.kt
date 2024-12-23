package com.sushkpavel.domain.usecase.bookmarks

import com.sushkpavel.domain.repository.BookmarksRepository

class GetBookmarksUseCase(
    private val repository: BookmarksRepository
) {
    fun execute() = repository.getBookmarks()
}