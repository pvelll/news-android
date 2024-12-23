package com.sushkpavel.data.local.entity

import kotlinx.serialization.Serializable

@Serializable
data class SourceEntity(
    val id: String?,
    val name: String?
)