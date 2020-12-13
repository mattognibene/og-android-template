package com.hermestraining.data.injection

import com.hermestraining.cache.room.DatabaseModule
import com.hermestraining.domain.dispatchers.AppDispatchers
import com.hermestraining.remote.NetworkModule
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
