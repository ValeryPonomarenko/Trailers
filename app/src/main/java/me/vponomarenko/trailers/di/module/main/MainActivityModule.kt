package me.vponomarenko.trailers.di.module.main

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import me.vponomarenko.trailers.di.module.ViewModelModule
import me.vponomarenko.trailers.di.scope.ActivityScope
import me.vponomarenko.trailers.di.scope.FragmentScope
import me.vponomarenko.trailers.router.MainActivityNavigator
import me.vponomarenko.trailers.router.base.INavigator
import me.vponomarenko.trailers.ui.fragment.MainFragment
import me.vponomarenko.trailers.ui.fragment.PlayerFragment

/**
 * Author: Valery Ponomarenko
 * Date: 12/02/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

@Module(includes = [ViewModelModule::class])
abstract class MainActivityModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun mainFragmentInjector(): MainFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [PlayerFragmentModule::class])
    abstract fun playerFragmentInjector(): PlayerFragment

    @Binds
    @ActivityScope
    abstract fun provideNavigator(navigator: MainActivityNavigator): INavigator

}