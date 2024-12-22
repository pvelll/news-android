package com.sushkpavel.news_app.presentation.screens.news

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sushkpavel.domain.usecase.news.GetNewsUseCase
import kotlinx.coroutines.launch

class NewsViewModel(private val getNewsUseCase: GetNewsUseCase) : ViewModel() {
    private var _screenState = mutableStateOf(NewsScreenState())
    val screenState: State<NewsScreenState> get() = _screenState

    fun updateCurrentPage(page: Int) {
        _screenState.value = _screenState.value.copy(currentPage = page)
    }

    fun updateScrollPosition(categoryIndex: Int, scrollPosition: Int) {
        _screenState.value.scrollPositions[categoryIndex] = scrollPosition
    }

    fun getScrollPosition(categoryIndex: Int): Int {
        return _screenState.value.scrollPositions[categoryIndex] ?: 0
    }

    fun getNewsByCategory(category: String) {
        viewModelScope.launch {
            screenState.value.news = getNewsUseCase.execute(category = category)
        }
    }
}