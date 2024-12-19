package com.sushkpavel.news_app.presentation.navigation.routes

import kotlinx.serialization.Serializable

sealed class Routes {

    @Serializable
    data object Bookmarks: Routes()

    @Serializable
    data object News: Routes()
}
