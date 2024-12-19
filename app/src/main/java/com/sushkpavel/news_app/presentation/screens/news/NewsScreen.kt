package com.sushkpavel.news_app.presentation.screens.news

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.navigation.NavHostController
import com.sushkpavel.news_app.R
import com.sushkpavel.news_app.presentation.utils.tab.TabIndicator

@Composable
fun NewsScreen(modifier: Modifier = Modifier, navController: NavHostController, context: Context) {
    val tabTitles = stringArrayResource(R.array.categories)
    val pagerState = rememberPagerState(pageCount = { tabTitles.size })

    Column(modifier = modifier.fillMaxSize()) {
        TabIndicator(tabTitles = tabTitles, pagerState = pagerState)
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { page ->
            Box(modifier = Modifier.fillMaxSize()) {
                Text(
                    text = "Content for ${tabTitles[page]}",
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}











