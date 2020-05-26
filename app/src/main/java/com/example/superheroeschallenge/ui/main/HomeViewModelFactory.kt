package com.example.superheroeschallenge.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.superheroeschallenge.data.DataSource
import com.example.superheroeschallenge.data.HeroRepository
import java.lang.IllegalArgumentException
import javax.inject.Inject

class HomeViewModelFactory @Inject constructor(private val heroRepository: DataSource):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)){
            return HomeViewModel(heroRepository) as T
        }
        throw IllegalArgumentException("modelClass has to be of type " + HomeViewModel::class.java.simpleName)
    }
}