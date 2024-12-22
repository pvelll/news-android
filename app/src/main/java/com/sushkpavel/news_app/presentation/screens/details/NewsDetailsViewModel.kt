package com.sushkpavel.news_app.presentation.screens.details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.sushkpavel.domain.model.News

class NewsDetailsViewModel : ViewModel() {
    private val _screenState = mutableStateOf<NewsDetailsScreenState?>(null)
    val screenState: State<NewsDetailsScreenState?> get() = _screenState

    fun setNews(news: News) {
        _screenState.value = NewsDetailsScreenState(news)
    }
}

