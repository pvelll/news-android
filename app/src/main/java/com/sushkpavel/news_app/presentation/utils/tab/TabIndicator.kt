package com.sushkpavel.news_app.presentation.utils.tab

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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