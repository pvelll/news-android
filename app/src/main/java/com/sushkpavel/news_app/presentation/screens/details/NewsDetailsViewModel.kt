package com.sushkpavel.news_app.presentation.screens.details

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sushkpavel.domain.model.News
import com.sushkpavel.domain.usecase.bookmarks.AddBookmarkUseCase
import com.sushkpavel.domain.usecase.bookmarks.DeleteBookmarkUseCase
import com.sushkpavel.domain.usecase.bookmarks.IsSavedUseCase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class NewsDetailsViewModel(
    private val addBookmarkUseCase: AddBookmarkUseCase,
    private val deleteBookmarkUseCase: DeleteBookmarkUseCase,
    private val isSavedUseCase: IsSavedUseCase
) : ViewModel() {
    private val _screenState = mutableStateOf<NewsDetailsScreenState?>(null)
    val screenState: MutableState<NewsDetailsScreenState?> get() = _screenState

    fun setNews(news: News) {
        viewModelScope.launch {
            _screenState.value = NewsDetailsScreenState(news)
        }
    }

    fun isSaved(news: News) = isSavedUseCase.execute(news)

    fun toggleBookmark(isSaved: Boolean) {
        viewModelScope.launch {
            if (isSaved) {
                screenState.value?.let { deleteBookmarkUseCase.execute(it.news) }
            } else {
                screenState.value?.let { addBookmarkUseCase.execute(it.news) }
            }
        }
    }
}




