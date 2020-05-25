package com.example.superheroeschallenge.ui.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.superheroeschallenge.HeroItem
import com.example.superheroeschallenge.data.DataSource
import com.example.superheroeschallenge.data.HeroRepository
import com.example.superheroeschallenge.data.LocalDataSource
import com.example.superheroeschallenge.data.RemoteDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HomeViewModel: ViewModel(){
    private val heroObservable:MutableLiveData<List<HeroItem>> = MutableLiveData()

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun getHeroObservable():LiveData<List<HeroItem>> = heroObservable

    private lateinit var repository : DataSource

    private lateinit var heroAdapter: HeroAdapter

    fun getHeroes(application: Application){
        heroAdapter = HeroAdapter()
        repository = HeroRepository(remoteDataSource = RemoteDataSource(),
            localDataSource = LocalDataSource(application))

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