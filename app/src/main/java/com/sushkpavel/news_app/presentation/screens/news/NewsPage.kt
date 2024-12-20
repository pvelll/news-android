package com.sushkpavel.news_app.presentation.screens.news

import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.paging.compose.collectAsLazyPagingItems

@Composable
fun NewsPage(
    category: String,
    pageIndex: Int,
    viewModel: NewsViewModel
) {
    val scrollState = rememberLazyListState(
        initialFirstVisibleItemIndex = viewModel.getScrollPosition(pageIndex)
    )

    LaunchedEffect(remember { derivedStateOf { scrollState.firstVisibleItemIndex } }) {
        viewModel.updateScrollPosition(pageIndex, scrollState.firstVisibleItemIndex)
    }
    LaunchedEffect(Unit) {
        viewModel.getNewsByCategory(category)
    }
    viewModel.screenState.value.news?.let { NewsList({}, it.collectAsLazyPagingItems()) }
}