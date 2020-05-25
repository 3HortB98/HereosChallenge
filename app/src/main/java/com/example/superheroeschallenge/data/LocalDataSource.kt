package com.example.superheroeschallenge.data

import android.app.Application
import androidx.room.Room
import com.example.superheroeschallenge.DATABASE_NAME
import com.example.superheroeschallenge.HeroItem
import io.reactivex.Maybe

class LocalDataSource(private val application: Application):DataSource {
    private val database: HeroDatabase by lazy {
        Room.databaseBuilder(application,HeroDatabase::class.java, DATABASE_NAME)
            .build()
    }
    override fun getHeroes() = database.heroDAO().getAllHeroes()

    override fun addHero(hero: HeroItem) {
        database.heroDAO().addHero(hero)
    }
}