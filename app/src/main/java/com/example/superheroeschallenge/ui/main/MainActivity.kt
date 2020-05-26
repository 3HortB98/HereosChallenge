package com.example.superheroeschallenge.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.superheroeschallenge.Heroes
import com.example.superheroeschallenge.R
import com.example.superheroeschallenge.di.ApplicationModule
import kotlinx.android.synthetic.main.main_activity.*
import javax.inject.Inject
import com.example.superheroeschallenge.di.DaggerAppComponent

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var homeViewModelFactory: HomeViewModelFactory

    private val heroAdapter = HeroAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        DaggerAppComponent.builder()
            .applicationModule(ApplicationModule(application))
            .build()
            .inject(this)

        rvHeroes.layoutManager = LinearLayoutManager(this)
        rvHeroes.adapter = heroAdapter

        val homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        val observer = Observer<List<Heroes>>{
            results->
            if (results !=null){
                heroAdapter.setData(results)
            }
        }

        homeViewModel.getHeroes(application)
        homeViewModel.getHeroObservable().observe(this,observer)

    }
}
