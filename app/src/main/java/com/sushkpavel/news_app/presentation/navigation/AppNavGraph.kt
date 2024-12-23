package com.sushkpavel.news_app.presentation.navigation

import android.content.Context
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.sushkpavel.domain.model.News
import com.sushkpavel.domain.model.Source
import com.sushkpavel.news_app.presentation.navigation.routes.Routes
import com.sushkpavel.news_app.presentation.screens.bookmarks.BookmarksScreen
import com.sushkpavel.news_app.presentation.screens.details.NewsDetailsScreen
import com.sushkpavel.news_app.presentation.screens.news.NewsScreen
import com.sushkpavel.news_app.presentation.screens.news.NewsViewModel
import kotlinx.serialization.json.Json
import org.koin.java.KoinJavaComponent.inject
import kotlin.reflect.typeOf

@Composable
fun AppNavGraph(navController: NavHostController, context: Context, paddingValues: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = Routes.ScreenNews,
        modifier = Modifier.padding(paddingValues)
    ) {
        //to easily save instance state of screen,if ill use koinViewModel in constructor ->
        // koin  will create new NewsVM everytime.
        val newsViewModel by inject<NewsViewModel>(NewsViewModel::class.java)

        composable<Routes.ScreenNews> {
            NewsScreen(navController = navController, context = context, viewModel = newsViewModel)
        }
        composable<Routes.ScreenBookmarks> {
            BookmarksScreen(navController = navController)
        }
        composable<Routes.ScreenNewsDetails>{
            val args = it.toRoute<Routes.ScreenNewsDetails>()
            NewsDetailsScreen(news = Json.decodeFromString(News.serializer(), args.news),navController = navController)
        }
    }
}// implement type-safe navigation, much better than common jetpack navigation
