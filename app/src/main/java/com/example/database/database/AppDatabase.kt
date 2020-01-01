package com.example.database.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.database.dao.BookDao
import com.example.database.entity.BookEntity

@Database(entities = [(BookEntity::class)],version = 1)
abstract class AppDatabase:RoomDatabase(){
    abstract fun bookDao():BookDao
}
