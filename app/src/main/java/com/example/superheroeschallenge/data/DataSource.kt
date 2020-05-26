package com.example.superheroeschallenge.data

import com.example.superheroeschallenge.Heroes
import io.reactivex.Maybe

interface DataSource {
    fun getHeroes(): Maybe<List<Heroes>>
    fun addHero(hero:Heroes)
}