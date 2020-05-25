package com.example.superheroeschallenge.net

import com.example.superheroeschallenge.ENDPOINT
import com.example.superheroeschallenge.HeroItem
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path


interface HeroService{
    @GET(ENDPOINT)
    fun getHeroes(): Single<List<HeroItem>>

//    @GET({picName})
//    fun getHeroPic(@Path("picName") picName: String?)
}