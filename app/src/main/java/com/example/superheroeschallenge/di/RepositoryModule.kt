package com.example.superheroeschallenge.di

import com.example.superheroeschallenge.data.DataSource
import com.example.superheroeschallenge.data.HeroRepository
import com.example.superheroeschallenge.data.LocalDataSource
import com.example.superheroeschallenge.data.RemoteDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Repository
    @Singleton
    fun provideRepository(@Remote remoteDataSource: RemoteDataSource, @Local localDataSource: LocalDataSource):DataSource{
        return HeroRepository(remoteDataSource, localDataSource)
    }

}