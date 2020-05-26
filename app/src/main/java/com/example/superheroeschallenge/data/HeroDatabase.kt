package com.example.superheroeschallenge.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.superheroeschallenge.DATABASE_VERSION
import com.example.superheroeschallenge.Heroes

@Database(entities = [Heroes::class],version = DATABASE_VERSION)
abstract class HeroDatabase: RoomDatabase() {
    abstract fun heroDAO():HeroDAO
}