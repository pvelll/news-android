package com.sushkpavel.news_app.presentation.navigation

import android.content.Context
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sushkpavel.news_app.presentation.navigation.routes.ScreenBookmarks
import com.sushkpavel.news_app.presentation.navigation.routes.ScreenNews
import com.sushkpavel.news_app.presentation.screens.bookmarks.BookmarksScreen
import com.sushkpavel.news_app.presentation.screens.news.NewsScreen

@Composable
fun AppNavGraph(navController: NavHostController, context: Context, paddingValues: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = ScreenNews,
        modifier = Modifier.padding(paddingValues)
    ) {
        composable<ScreenNews> {
            NewsScreen(navController = navController, context = context)
        }
        composable<ScreenBookmarks> {
            BookmarksScreen(navController = navController, context = context)
        }
    }
}
