package me.vponomarenko.trailers

import android.app.Activity
import android.app.Application
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import me.vponomarenko.trailers.di.component.DaggerAppComponent
import javax.inject.Inject

/**
 * Author: Valery Ponomarenko
 * Date: 12/02/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class TrailersApplication : Application(), HasActivityInjector {

    @Inject
    protected lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder()
                .context(this)
                .build()
                .inject(this)
    }

    override fun activityInjector() = dispatchingActivityInjector

}