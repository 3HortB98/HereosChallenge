package com.example.superheroeschallenge.data

import com.example.superheroeschallenge.BASE_URL
import com.example.superheroeschallenge.HeroItem
import com.example.superheroeschallenge.net.HeroService
import io.reactivex.Maybe
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RemoteDataSource:DataSource {

    private val heroService : HeroService by lazy{
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        retrofit.create(HeroService::class.java)
    }
    override fun getHeroes(): Maybe<List<HeroItem>> {
        return heroService.getHeroes().flatMapMaybe { Maybe.just(it) }
    }

    override fun addHero(hero: HeroItem) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}