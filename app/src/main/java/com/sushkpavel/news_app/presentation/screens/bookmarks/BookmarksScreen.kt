package com.sushkpavel.news_app.presentation.screens.bookmarks

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.sushkpavel.domain.model.News
import com.sushkpavel.news_app.R
import com.sushkpavel.news_app.presentation.navigation.routes.Routes
import com.sushkpavel.news_app.presentation.utils.news.NewsItem
import kotlinx.serialization.json.Json
import org.koin.androidx.compose.koinViewModel

@Composable
fun BookmarksScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: BookmarksViewModel = koinViewModel()
) {
    val bookmarks by viewModel.bookmarks.collectAsState()
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.bookmarks),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
    ) {
        Box(
            modifier = modifier
                .padding(it)
                .fillMaxSize()
        ) {
            LazyColumn(
                contentPadding = PaddingValues(
                    horizontal = 16.dp,
                    vertical = 8.dp
                ),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(bookmarks) { news ->
                    NewsItem(
                        news = news,
                        onClick = {
                            navController.navigate(Routes.ScreenNewsDetails(Json.encodeToString(News.serializer(), news)))
                        }
                    )
                }
            }
        }
    }
}
