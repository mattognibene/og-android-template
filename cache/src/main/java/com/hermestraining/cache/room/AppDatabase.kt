package com.hermestraining.cache.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hermestraining.cache.room.model.ToBeDeleted

@Database(
    entities = [
        ToBeDeleted::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase()
