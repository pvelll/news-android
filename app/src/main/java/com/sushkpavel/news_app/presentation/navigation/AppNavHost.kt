package com.sushkpavel.news_app.presentation.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sushkpavel.news_app.presentation.navigation.routes.ScreenBookmarks
import com.sushkpavel.news_app.presentation.navigation.routes.ScreenNews
import com.sushkpavel.news_app.presentation.screens.bookmarks.BookmarksScreen
import com.sushkpavel.news_app.presentation.screens.news.NewsScreen

@Composable
fun AppNavHost(navController: NavHostController, context: Context) {
    NavHost(
        navController = navController,
        startDestination = ScreenNews
    ) {
        composable<ScreenNews> {
            NewsScreen(navController = navController, context = context)
        }
        composable<ScreenBookmarks> {
            BookmarksScreen(navController = navController, context = context)
        }
    }
}
