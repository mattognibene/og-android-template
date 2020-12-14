package com.example.remote

import dagger.Module
import dagger.Provides
import okhttp3.logging.HttpLoggingInterceptor

@Module
internal object NetworkSettings {
    @Provides
    @JvmStatic
    fun providesLoggingLevel(): HttpLoggingInterceptor.Level = HttpLoggingInterceptor.Level.BODY
}
