package com.hermestraining.domain.dispatchers

import kotlinx.coroutines.CoroutineDispatcher

interface AppDispatchers {
    val io: CoroutineDispatcher
    val mainThread: CoroutineDispatcher
    val computation: CoroutineDispatcher
}
