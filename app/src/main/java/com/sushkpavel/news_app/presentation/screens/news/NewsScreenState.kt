package com.sushkpavel.news_app.presentation.screens.news

import androidx.paging.PagingData
import com.sushkpavel.domain.model.News
import kotlinx.coroutines.flow.Flow

data class NewsScreenState(
    var currentPage: Int = 0,
    val scrollPositions: MutableMap<Int, Int> = mutableMapOf(),
    var news: Map<String, Flow<PagingData<News>>> = mapOf()
)