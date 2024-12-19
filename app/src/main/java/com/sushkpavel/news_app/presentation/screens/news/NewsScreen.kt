package com.sushkpavel.news_app.presentation.screens.news

import android.content.Context
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.sushkpavel.news_app.R
import kotlinx.coroutines.launch
import java.util.Locale

@Composable
fun NewsScreen(modifier: Modifier = Modifier, navController: NavHostController, context: Context) {
    val tabTitles = stringArrayResource(R.array.categories)
    val pagerState = rememberPagerState(pageCount = { tabTitles.size })

    Column(modifier = modifier.fillMaxSize()) {
        TabIndicator(tabTitles = tabTitles, pagerState = pagerState)

        // Полезная нагрузка таба
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

@Composable
fun TabIndicator(tabTitles: Array<String>, pagerState: PagerState) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TabText(
            text = if (pagerState.currentPage - 1 >= 0) tabTitles[pagerState.currentPage - 1] else null,
            fontSize = 10.sp,
            style = MaterialTheme.typography.bodySmall,
            alignment = Alignment.BottomStart,
            modifier = Modifier.weight(1f)
        )

        TabText(
            text = tabTitles[pagerState.currentPage],
            fontSize = 16.sp,
            style = MaterialTheme.typography.bodyLarge,
            alignment = Alignment.TopCenter,
            modifier = Modifier.weight(1f)
        )

        TabText(
            text = if (pagerState.currentPage + 1 < tabTitles.size) tabTitles[pagerState.currentPage + 1] else null,
            fontSize = 10.sp,
            style = MaterialTheme.typography.bodySmall,
            alignment = Alignment.BottomEnd,
            modifier = Modifier.weight(1f)
        )
    }
}


@Composable
fun TabText(
    text: String?,
    fontSize: TextUnit,
    style: TextStyle,
    alignment: Alignment,
    modifier: Modifier = Modifier
) {
    if (text != null) {
        Box(modifier = modifier) {
            Text(
                text = text.replaceFirstChar {
                    if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
                },
                fontSize = fontSize,
                style = style,
                modifier = Modifier.align(alignment)
            )
        }
    } else {
        Spacer(modifier = modifier)
    }
}






