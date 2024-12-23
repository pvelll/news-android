package com.sushkpavel.news_app.presentation.screens.bookmarks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sushkpavel.domain.usecase.bookmarks.GetBookmarksUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class BookmarksViewModel(
    getBookmarksUseCase: GetBookmarksUseCase,
) : ViewModel() {
    val bookmarks = getBookmarksUseCase.execute().stateIn(
        viewModelScope,
        started = SharingStarted.WhileSubscribed(2000),
        initialValue = emptyList()
    )
}