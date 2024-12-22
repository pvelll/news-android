package com.sushkpavel.domain.model

import kotlinx.serialization.Serializable
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

@Serializable
data class News(
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String?
){
    fun formatDateTime(): String {
        val zonedDateTime = ZonedDateTime.parse(publishedAt)
        val formatter = DateTimeFormatter.ofPattern("d MMMM yyyy, HH:mm", Locale.UK)
        return zonedDateTime.format(formatter)
    }

    fun processContent(): String {
        val regex = "\\[.*?\\]".toRegex()
        return content?.replace(regex, "") ?: ""
    }

}