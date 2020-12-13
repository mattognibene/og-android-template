package com.hermestraining

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.hermestraining.calendar.CalendarFragment
import com.hermestraining.common.BaseFragment
import com.hermestraining.hermes.R
import com.hermestraining.startactivity.StartActivityFragment
import com.hermestraining.viewactivities.ViewActivitiesFragment
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this, viewModelFactory)[MainViewModel::class.java]

        navigationView.setOnNavigationItemSelectedListener { menuItem ->
            selectFragment(NavigationTab.fromId(menuItem.itemId), true)
            true
        }
    }

    private fun selectFragment(tab: NavigationTab, addToBackStack: Boolean = false) {
        val transaction = supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, tab.newFragment())

        if (addToBackStack) {
            transaction.addToBackStack(null)
        }

        transaction.commit()
    }

    enum class NavigationTab(
        @IdRes val id: Int,
        val newFragment: () -> BaseFragment
    ) {
        START_ACTIVITY(
            id = R.id.menu_item_go,
            newFragment = { StartActivityFragment() }
        ),
        VIEW_ACTIVITIES(
            id = R.id.menu_item_activities,
            newFragment = { ViewActivitiesFragment() }
        ),
        CALENDAR(
            id = R.id.menu_item_calendar,
            newFragment = { CalendarFragment() }
        );

        companion object {
            fun fromId(@IdRes id: Int): NavigationTab {
                for (tab in values()) {
                    if (tab.id == id) {
                        return tab
                    }
                }
                throw IllegalArgumentException("No tab with id of $id found.")
            }
        }
    }
}
