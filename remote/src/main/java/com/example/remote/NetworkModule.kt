package com.example.remote

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module(includes = [NetworkSettings::class])
object NetworkModule {
    @Provides
    @JvmStatic
    fun providesBaseUrl(): HttpUrl? {
        return "TODO: Please provide an appropriate base URL!".toHttpUrlOrNull()
    }

    @Provides
    @Singleton
    @JvmStatic
    fun providesRetrofit(url: HttpUrl?, level: HttpLoggingInterceptor.Level): Retrofit {
        HttpLoggingInterceptor()
        val logging = HttpLoggingInterceptor().apply { this.level = level }

        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        val moshi = Moshi.Builder()
            // .add(AppJsonAdapterFactory.INSTANCE) TODO do we need Kotshi?
            .build()

        return Retrofit.Builder()
            .baseUrl(requireNotNull(url))
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }
}
