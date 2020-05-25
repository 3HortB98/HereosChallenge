package com.example.superheroeschallenge.data

import com.example.superheroeschallenge.HeroItem
import io.reactivex.Maybe

interface DataSource {
    fun getHeroes(): Maybe<List<HeroItem>>
    fun addHero(hero:HeroItem)
}