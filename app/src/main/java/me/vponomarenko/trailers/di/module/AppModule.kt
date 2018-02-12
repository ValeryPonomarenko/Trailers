package me.vponomarenko.trailers.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import me.vponomarenko.trailers.di.module.main.MainActivityModule
import me.vponomarenko.trailers.di.scope.ActivityScope
import me.vponomarenko.trailers.ui.activity.MainActivity

/**
 * Author: Valery Ponomarenko
 * Date: 12/02/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

@Module(includes = [AndroidSupportInjectionModule::class])
abstract class AppModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun mainActivityInjector(): MainActivity

}