package com.sushkpavel.news_app.presentation.navigation.routes

import kotlinx.serialization.Serializable

sealed class Routes {

    @Serializable
    data object HomeGraph: Routes()

    @Serializable
    data object Bookmarks: Routes()

    @Serializable
    data class Search(val searchText: String? = null): Routes()

    @Serializable
    data object News: Routes()

    @Serializable
    data class ProfileInfo(val userId: String): Routes()
}
