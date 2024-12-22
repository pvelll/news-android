package com.sushkpavel.news_app.presentation.utils.fab

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SaveBookmarksFloatingButton(onClick : () -> Unit, isSaved: Boolean, modifier: Modifier = Modifier) {
    FloatingActionButton(
        modifier = modifier,
        onClick = onClick
    ) {
        Icon(if(isSaved)Icons.Default.Favorite else Icons.Default.FavoriteBorder, "Save indicator")
    }
}