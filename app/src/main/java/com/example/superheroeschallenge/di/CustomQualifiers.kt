package com.example.superheroeschallenge.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Remote

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Repository

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Local