package com.example

import android.app.Application
import com.example.common.AppBindings
import com.example.common.ViewModelModule
import com.example.data.injection.DataModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        BuildTypeModule::class,
        ViewModelModule::class,
        AppBindings::class,
        DataModule::class
    ]
)
interface AppComponent : AndroidInjector<ExampleApp> {
    @Component.Builder
    interface Builder {
        @BindsInstance fun app(app: Application): Builder
        fun build(): AppComponent
    }
}
