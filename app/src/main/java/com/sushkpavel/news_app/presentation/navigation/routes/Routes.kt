package com.sushkpavel.news_app.presentation.navigation.routes

import com.sushkpavel.domain.model.News
import kotlinx.serialization.Serializable

sealed class Routes {

    @Serializable
    data object ScreenBookmarks: Routes()

    @Serializable
    data object ScreenNews: Routes()

    @Serializable
    data class ScreenNewsDetails(val news: String) : Routes() // the easiest way is to parse object to json string and reparse is by parameter
}
