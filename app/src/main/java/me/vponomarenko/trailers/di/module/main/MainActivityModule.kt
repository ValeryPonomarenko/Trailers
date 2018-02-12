package me.vponomarenko.trailers.di.module.main

import dagger.Module
import dagger.android.ContributesAndroidInjector
import me.vponomarenko.trailers.di.module.ViewModelModule
import me.vponomarenko.trailers.di.scope.FragmentScope
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
    @ContributesAndroidInjector
    abstract fun playerFragmentInjector(): PlayerFragment

}