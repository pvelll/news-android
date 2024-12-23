package com.sushkpavel.data.local.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sushkpavel.data.utils.Utils.BOOKMARKS_TABLE_NAME
import com.sushkpavel.domain.model.News
import com.sushkpavel.domain.model.Source
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = BOOKMARKS_TABLE_NAME)
data class NewsEntity(
    @PrimaryKey val url: String,
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    @Embedded val source: SourceEntity,
    val title: String?,
    val urlToImage: String?
)

fun NewsEntity.toNews(): News = News(
    author = this.author ?: "",
    content = this.content ?: "",
    description = this.description ?: "",
    publishedAt = this.publishedAt ?: "",
    source = Source(
        id = this.source.id ?: "",
        name = this.source.name ?: ""
    ),
    title = this.title ?: "",
    url = this.url,
    urlToImage = this.urlToImage ?: ""
)

fun News.toEntity(): NewsEntity = NewsEntity(
    author = this.author,
    content = this.content,
    description = this.description,
    publishedAt = this.publishedAt,
    source = SourceEntity(
        id = this.source.id,
        name = this.source.name
    ),
    title = this.title,
    url = this.url,
    urlToImage = this.urlToImage
)

