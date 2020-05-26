package com.example.superheroeschallenge.data

import androidx.room.*
import com.example.superheroeschallenge.Heroes
import io.reactivex.Maybe

@Dao
interface HeroDAO {
    @Query("Select * From Heroes")
    fun getAllHeroes(): Maybe<List<Heroes>>

    @Insert
    fun addHero(hero: Heroes)

    @Delete
    fun deleteHero(hero: Heroes)

    @Update
    fun updateHero(hero: Heroes)
}