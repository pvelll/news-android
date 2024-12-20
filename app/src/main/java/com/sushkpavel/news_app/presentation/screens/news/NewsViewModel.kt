package com.sushkpavel.news_app.presentation.screens.news

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class NewsViewModel : ViewModel(){
    fun updateCurrentPage(page: Int) {
        _screenState.value = _screenState.value.copy(currentPage = page)
    }

    private var _screenState = mutableStateOf(NewsScreenState())
    val screenState : State<NewsScreenState> get() = _screenState
}