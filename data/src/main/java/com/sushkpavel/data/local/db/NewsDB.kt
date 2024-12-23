package com.sushkpavel.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sushkpavel.data.local.dao.NewsDao
import com.sushkpavel.data.local.entity.NewsEntity

@Database(
    entities = [NewsEntity::class],
    version = 1,
    exportSchema = true
)
abstract class NewsDB : RoomDatabase() {
    abstract fun newsDao(): NewsDao
}