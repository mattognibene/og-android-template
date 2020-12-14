package com.example

import android.os.StrictMode
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import timber.log.Timber
import javax.inject.Inject

class ExampleApp : DaggerApplication() {
    @Inject lateinit var threadPolicy: StrictMode.ThreadPolicy
    @Inject lateinit var vmPolicy: StrictMode.VmPolicy
    @Inject lateinit var tree: Timber.Tree

    val component by lazy {
        DaggerAppComponent.builder().app(this).build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
        StrictMode.setThreadPolicy(threadPolicy)
        StrictMode.setVmPolicy(vmPolicy)
        Timber.plant(tree)
    }
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return component
    }
}
