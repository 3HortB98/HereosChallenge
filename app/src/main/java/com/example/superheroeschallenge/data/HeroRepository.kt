package com.example.superheroeschallenge.data

import com.example.superheroeschallenge.Heroes
import io.reactivex.Maybe

class HeroRepository(private val remoteDataSource: DataSource,
                     private val localDataSource: DataSource): DataSource {

    override fun getHeroes(): Maybe<List<Heroes>> {
        return remoteDataSource.getHeroes()
            .doOnSuccess {
                it.forEach{hero->addHero(hero)}
            }
            .onErrorResumeNext { _:Throwable->localDataSource.getHeroes() }
    }

    override fun addHero(hero: Heroes) {
        localDataSource.addHero(hero)
    }

}