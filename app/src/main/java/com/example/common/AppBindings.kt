package com.example.common

import com.example.MainActivity
import com.example.calendar.CalendarFragment
import com.example.startactivity.StartActivityFragment
import com.example.viewactivities.ViewActivitiesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppBindings {
    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity
}
