package com.example.superheroeschallenge.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.superheroeschallenge.HeroItem
import com.example.superheroeschallenge.R
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    private val heroAdapter = HeroAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        rvHeroes.layoutManager = LinearLayoutManager(this)
        rvHeroes.adapter = heroAdapter

        val homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        val observer = Observer<List<HeroItem>>{
            results->
            if (results !=null){
                heroAdapter.setData(results)
            }
        }

        homeViewModel.getHeroes(application)
        homeViewModel.getHeroObservable().observe(this,observer)

    }
}
