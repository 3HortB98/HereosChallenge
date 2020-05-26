package com.example.superheroeschallenge.di

import android.app.Application
import com.example.superheroeschallenge.ui.main.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class, ApplicationModule::class])
@Singleton
interface AppComponent {

    @Component.Builder
    interface Builder {


        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
    fun inject(mainActivity: MainActivity)
}