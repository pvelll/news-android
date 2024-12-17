package com.sushkpavel.data.model

import com.sushkpavel.domain.model.News
import kotlinx.serialization.Serializable

@Serializable
data class NewsDto(
    val articles: List<News>,
    val status: String,
    val totalResults: Int
)