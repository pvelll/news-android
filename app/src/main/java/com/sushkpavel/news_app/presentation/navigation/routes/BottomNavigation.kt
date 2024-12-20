package com.sushkpavel.news_app.presentation.navigation.routes

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.graphics.vector.ImageVector

enum class BottomNavigation(val label: String, val icon: ImageVector, val route: Routes) {
    NEWS("News", Icons.Filled.Menu, Routes.ScreenNews),
    BOOKMARKS("Bookmarks", Icons.Filled.Favorite, Routes.ScreenBookmarks);
}