package com.sushkpavel.news_app.presentation.screens.news

import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.paging.compose.collectAsLazyPagingItems
import com.sushkpavel.domain.model.News
import com.sushkpavel.news_app.presentation.utils.news.NewsList

@Composable
fun NewsPage(
    onClickNews: (News) -> Unit,
    pageIndex: Int,
    viewModel: NewsViewModel,
    category: String
) {
    val scrollState =
        rememberLazyListState(initialFirstVisibleItemIndex = viewModel.getScrollPosition(pageIndex))
    LaunchedEffect(remember { derivedStateOf { scrollState.firstVisibleItemIndex } }) {
        viewModel.updateScrollPosition(
            pageIndex,
            scrollState.firstVisibleItemIndex
        )
    }
    val newsFlow = viewModel.screenState.value.news[category]
    newsFlow?.let {
        NewsList(
            onClickNews,
            it.collectAsLazyPagingItems()
        )
    }
}