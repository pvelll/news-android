package com.sushkpavel.news_app.presentation.screens.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sushkpavel.domain.model.News
import com.sushkpavel.domain.model.Source
import com.sushkpavel.news_app.presentation.utils.news.NewsImage
import com.sushkpavel.news_app.presentation.utils.text.ClickableUrlText
import org.koin.androidx.compose.koinViewModel

@Composable
fun NewsDetailsScreen(
    news: News,
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: NewsDetailsViewModel = koinViewModel()
) {
    LaunchedEffect(news) {
        viewModel.setNews(news)
    }

    val screenState by viewModel.screenState

    screenState?.let { state ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            state.news.urlToImage?.let { imageUrl ->
                NewsImage(
                    imageUrl = imageUrl,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = state.news.title,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "By ${state.news.author ?: "Unknown"}",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = state.news.formatDateTime(),
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = state.news.processContent(),
                style = MaterialTheme.typography.bodyMedium
            )
            ClickableUrlText(
                url = state.news.url,
                modifier = modifier,
                textStyle = MaterialTheme.typography.bodyMedium
            )
        }
    }
}


@Preview
@Composable
private fun NewsDetailsScreenPreview() {
    NewsDetailsScreen(
        News(
            author = "Nick Kosko",
            content = "The College GameDay Podcast was seemingly split on Penn State and SMU in the first round of the College Football Playoff. ESPNs Ryan McGee decided to side with the Mustangs while Pete Thamel opted f… [+2140 chars]",
            description = ".",
            publishedAt = "2024-12-21T14:55:21Z",
            source = Source(id = null, name = "On3.com"),
            title = "College GameDay podcast predicts outcome of Penn State vs. SMU - On3.com",
            url = "https://www.on3.com/news/college-gameday-podcast-predicts-outcome-of-penn-state-vs-smu/",
            urlToImage = "https://on3static.com/uploads/dev/assets/cms/2024/12/21085259/imgonline-com-ua-twotoone-TVrPypRAXkCM7U-1.jpg"
        ),
        navController = rememberNavController(),
        viewModel = NewsDetailsViewModel()
    )
}
