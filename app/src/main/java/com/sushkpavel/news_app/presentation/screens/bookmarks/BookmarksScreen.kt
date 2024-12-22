package com.sushkpavel.news_app.presentation.screens.bookmarks

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import org.koin.androidx.compose.koinViewModel

@Composable
fun BookmarksScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    context: Context,
    viewModel: BookmarksViewModel = koinViewModel()
) {
    
}