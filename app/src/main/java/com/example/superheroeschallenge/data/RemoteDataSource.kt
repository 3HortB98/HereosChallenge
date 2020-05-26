package com.example.superheroeschallenge.data

import com.example.superheroeschallenge.BASE_URL
import com.example.superheroeschallenge.Heroes
import com.example.superheroeschallenge.net.HeroService
import io.reactivex.Maybe
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val heroService: HeroService): DataSource {

    override fun getHeroes(): Maybe<List<Heroes>> {
        return heroService.getHeroes().flatMapMaybe { Maybe.just(it) }
    }

    override fun addHero(hero: Heroes) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}