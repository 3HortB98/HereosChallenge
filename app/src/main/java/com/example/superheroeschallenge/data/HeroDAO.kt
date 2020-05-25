package com.example.superheroeschallenge.data

import androidx.room.*
import com.example.superheroeschallenge.HeroItem
import io.reactivex.Maybe

@Dao
interface HeroDAO {
    @Query("Select * From Heroes")
    fun getAllHeroes(): Maybe<List<HeroItem>>

    @Insert
    fun addHero(hero: HeroItem)

    @Delete
    fun deleteHero(hero: HeroItem)

    @Update
    fun updateHero(hero: HeroItem)
}