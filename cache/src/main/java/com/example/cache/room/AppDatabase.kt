package com.example.cache.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cache.room.model.ToBeDeleted

@Database(
    entities = [
        ToBeDeleted::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase()
