package me.vponomarenko.trailers.di.module

import android.arch.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import me.vponomarenko.trailers.di.annotation.ViewModelKey
import me.vponomarenko.trailers.viewmodel.MainViewModel
import me.vponomarenko.trailers.viewmodel.PlayerViewModel

/**
 * Author: Valery Ponomarenko
 * Date: 12/02/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */
 
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun provideMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PlayerViewModel::class)
    abstract fun providePlayerViewModel(viewModel: PlayerViewModel): ViewModel

}