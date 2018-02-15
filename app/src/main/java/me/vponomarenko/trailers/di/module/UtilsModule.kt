package me.vponomarenko.trailers.di.module

import dagger.Module
import dagger.Provides
import me.vponomarenko.trailers.utils.palette.PaletteHelper
import javax.inject.Singleton

/**
 * Author: Valery Ponomarenko
 * Date: 15/02/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

@Module
class UtilsModule {

    @Singleton
    @Provides
    fun providePaletteHelper() = PaletteHelper()

}