package com.example.common

import com.example.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppBindings {
    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity
}
