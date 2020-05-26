package com.example.superheroeschallenge.net

import com.example.superheroeschallenge.ENDPOINT
import com.example.superheroeschallenge.Heroes
import io.reactivex.Single
import retrofit2.http.GET


interface HeroService{
    @GET(ENDPOINT)
    fun getHeroes(): Single<List<Heroes>>

//    @GET({picName})
//    fun getHeroPic(@Path("picName") picName: String?)
}