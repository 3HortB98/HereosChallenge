package com.example.superheroeschallenge.di

import android.app.Application
import android.content.Context
import com.example.superheroeschallenge.data.DataSource
import com.example.superheroeschallenge.data.HeroRepository
import com.example.superheroeschallenge.data.LocalDataSource
import com.example.superheroeschallenge.data.RemoteDataSource
import com.example.superheroeschallenge.ui.main.HomeViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: Application) {
    @Provides
    @Singleton
    fun provideApplicationContext()= application

    @Provides
    @Singleton
    @Repository
    fun provideRepository(@Remote remoteDataSource: RemoteDataSource, @Local localDataSource: LocalDataSource): DataSource{
        return HeroRepository(remoteDataSource, localDataSource)
    }

    @Provides
    @Singleton
    fun provideHomeViewModelFactory(@Repository repository: DataSource): HomeViewModelFactory{
        return HomeViewModelFactory(repository)
    }

}