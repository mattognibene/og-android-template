package com.hermestraining.common

import com.hermestraining.MainActivity
import com.hermestraining.calendar.CalendarFragment
import com.hermestraining.startactivity.StartActivityFragment
import com.hermestraining.viewactivities.ViewActivitiesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppBindings {
    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun calendarFragment(): CalendarFragment

    @ContributesAndroidInjector
    abstract fun viewActivitiesFragment(): ViewActivitiesFragment

    @ContributesAndroidInjector
    abstract fun startActivityFragment(): StartActivityFragment
}
