package com.example.superheroeschallenge.di

import android.app.Application
import com.example.superheroeschallenge.API_TIMEOUT
import com.example.superheroeschallenge.BASE_URL
import com.example.superheroeschallenge.CACHE_SIZE
import com.example.superheroeschallenge.data.DataSource
import com.example.superheroeschallenge.data.RemoteDataSource
import com.example.superheroeschallenge.net.HeroService
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideCache(application: Application): Cache {
        return Cache(application.cacheDir, CACHE_SIZE)
    }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }


    @Provides
    @Singleton
    fun provideOkHttpClient(cache:Cache, httpLoggingInterceptor:HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .readTimeout(API_TIMEOUT, TimeUnit.SECONDS)
            .connectTimeout(API_TIMEOUT, TimeUnit.SECONDS)
            .cache(cache)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient:OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideService(retrofit:Retrofit): HeroService {
        return retrofit.create(HeroService:: class.java)
    }

    @Provides
    @Singleton
    @Remote
    fun provideRemoteDataSource(service:HeroService): DataSource

    {
        return RemoteDataSource(service)
    }
}