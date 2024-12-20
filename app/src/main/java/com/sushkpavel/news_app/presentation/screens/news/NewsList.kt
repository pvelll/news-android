package com.sushkpavel.news_app.presentation.screens.news


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.sushkpavel.domain.model.News
import com.sushkpavel.news_app.presentation.utils.components.EmptyStateComponent
import com.sushkpavel.news_app.presentation.utils.components.ErrorStateComponent
import com.sushkpavel.news_app.presentation.utils.components.LoadingStateComponent

@Composable
fun NewsList(
    onClickNews: (News) -> Unit,
    newsPaging: LazyPagingItems<News>,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(
            horizontal = 16.dp,
            vertical = 8.dp
        ),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(newsPaging.itemCount) {
            val news = newsPaging[it]
            if (news != null) {
                NewsItem(
                    news = news,
                    onClick = {
                        onClickNews(news)
                    }
                )
            }
        }
        newsPaging.loadState.let { loadState ->
            when {
                loadState.refresh is LoadState.Loading -> {
                    item {
                        Box(
                            modifier = Modifier.fillParentMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            LoadingStateComponent()
                        }
                    }
                }

                loadState.refresh is LoadState.NotLoading && newsPaging.itemCount < 1 -> {
                    item {
                        Box(
                            modifier = Modifier.fillParentMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            EmptyStateComponent(
                                message = "Error"
                            )
                        }
                    }
                }

                loadState.refresh is LoadState.Error -> {
                    val error = loadState.refresh as LoadState.Error
                    item {
                        Box(
                            modifier = Modifier.fillParentMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            error.error.message?.let {
                                ErrorStateComponent(
                                    message = it
                                )
                            }
                        }
                    }
                }

                loadState.append is LoadState.Loading -> {
                    item {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator(
                                modifier =
                                Modifier
                                    .size(16.dp)
                                    .align(Alignment.Center),
                                strokeWidth = 2.dp
                            )
                        }
                    }
                }
            }
        }
    }
}