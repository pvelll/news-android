package com.sushkpavel.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sushkpavel.data.local.entity.NewsEntity
import kotlinx.coroutines.flow.Flow
import com.sushkpavel.data.utils.Utils.BOOKMARKS_TABLE_NAME

@Dao
interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(news: NewsEntity)

    @Delete
    suspend fun delete(news: NewsEntity)

    @Query("SELECT * FROM $BOOKMARKS_TABLE_NAME")
    fun getAll(): Flow<List<NewsEntity>>

    @Query("SELECT EXISTS(SELECT * FROM $BOOKMARKS_TABLE_NAME WHERE url = :url)")
    fun isSaved(url: String): Flow<Boolean>
}