package com.sushkpavel.news_app.presentation.screens.news

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.navigation.NavHostController
import com.sushkpavel.news_app.R
import com.sushkpavel.news_app.presentation.utils.news.NewsPage
import com.sushkpavel.news_app.presentation.utils.tab.TabIndicator

@Composable
fun NewsScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    context: Context,
    viewModel: NewsViewModel
) {
    val categories = stringArrayResource(R.array.categories)
    val pagerState = rememberPagerState(initialPage = viewModel.screenState.value.currentPage) { categories.size }

    LaunchedEffect(pagerState.currentPage) {
        viewModel.updateCurrentPage(pagerState.currentPage)
    }

    Column(modifier = modifier.fillMaxSize()) {
        TabIndicator(tabTitles = categories, pagerState = pagerState)
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { page ->
            NewsPage(
                category = categories[page],
                pageIndex = page,
                viewModel = viewModel
            )
        }
    }
}















