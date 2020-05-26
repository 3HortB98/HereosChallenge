package com.example.superheroeschallenge.ui.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.superheroeschallenge.Heroes
import com.example.superheroeschallenge.data.DataSource
import com.example.superheroeschallenge.data.HeroRepository
import com.example.superheroeschallenge.data.LocalDataSource
import com.example.superheroeschallenge.data.RemoteDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HomeViewModel(private var repository : DataSource ): ViewModel(){
    private val heroObservable: MutableLiveData<List<Heroes>> = MutableLiveData()

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun getHeroObservable():LiveData<List<Heroes>> = heroObservable

    private lateinit var heroAdapter: HeroAdapter

    fun getHeroes(){

        compositeDisposable.add(repository.getHeroes()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                heroObservable.value= it
            },{
                it.printStackTrace()
            }))
    }

}