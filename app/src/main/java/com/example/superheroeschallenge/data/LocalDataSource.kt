package com.example.superheroeschallenge.data

import android.app.Application
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.superheroeschallenge.DATABASE_NAME
import com.example.superheroeschallenge.Heroes

class LocalDataSource(private val application: Application):DataSource {
    val MIGRATION_1_2: Migration = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) { // Since we didn't alter the table, there's nothing else to do here.
        }
    }
    private val database: HeroDatabase by lazy {
        Room.databaseBuilder(application,HeroDatabase::class.java, DATABASE_NAME)
            .addMigrations(MIGRATION_1_2)
            .build()
    }
    override fun getHeroes() = database.heroDAO().getAllHeroes()

    override fun addHero(hero: Heroes) {
        database.heroDAO().addHero(hero)
    }
}