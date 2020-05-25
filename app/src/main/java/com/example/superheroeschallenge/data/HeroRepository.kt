package com.example.superheroeschallenge.data

import com.example.superheroeschallenge.HeroItem
import io.reactivex.Maybe

class HeroRepository(private val remoteDataSource: RemoteDataSource,
                     private val localDataSource: LocalDataSource): DataSource {
    override fun getHeroes(): Maybe<List<HeroItem>> {
        return remoteDataSource.getHeroes()
            .doOnSuccess {
                it.forEach{hero->addHero(hero)}
            }
            .onErrorResumeNext { _:Throwable->localDataSource.getHeroes() }
    }

    override fun addHero(hero: HeroItem) {
        localDataSource.addHero(hero)
    }

}