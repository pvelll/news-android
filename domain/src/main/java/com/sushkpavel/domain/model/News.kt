package com.sushkpavel.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class News(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
)