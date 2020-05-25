package com.example.superheroeschallenge.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.superheroeschallenge.DATABASE_VERSION
import com.example.superheroeschallenge.HeroItem

@Database(entities = [HeroItem::class],version = DATABASE_VERSION)
abstract class HeroDatabase: RoomDatabase() {
    abstract fun heroDAO():HeroDAO
}