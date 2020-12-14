package com.example.data.injection

import com.example.cache.room.DatabaseModule
import com.example.domain.dispatchers.AppDispatchers
import com.example.remote.NetworkModule
import dagger.Module
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module(
    includes = [
        DatabaseModule::class,
        NetworkModule::class,
        DataBindings::class
    ]
)
object DataModule {
    fun provideDispatchers(): AppDispatchers {
        return object : AppDispatchers {
            override val io: CoroutineDispatcher get() = Dispatchers.IO
            override val mainThread: CoroutineDispatcher get() = Dispatchers.Main
            override val computation: CoroutineDispatcher get() = Dispatchers.Default
        }
    }
}
