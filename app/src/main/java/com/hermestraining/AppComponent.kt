package com.hermestraining

import android.app.Application
import com.hermestraining.common.AppBindings
import com.hermestraining.common.ViewModelModule
import com.hermestraining.data.injection.DataModule
import com.hermestraining.hermes.BuildTypeModule
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
interface AppComponent : AndroidInjector<HermesApp> {
    @Component.Builder
    interface Builder {
        @BindsInstance fun app(app: Application): Builder
        fun build(): AppComponent
    }
}
