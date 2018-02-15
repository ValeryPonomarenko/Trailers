package me.vponomarenko.trailers.di.component

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import me.vponomarenko.trailers.TrailersApplication
import me.vponomarenko.trailers.di.module.AppModule
import me.vponomarenko.trailers.di.module.RepositoryModule
import me.vponomarenko.trailers.di.module.UtilsModule
import javax.inject.Singleton

/**
 * Author: Valery Ponomarenko
 * Date: 12/02/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

@Singleton
@Component(modules = [
    AppModule::class,
    RepositoryModule::class,
    UtilsModule::class
])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder
        fun build(): AppComponent
    }

    fun inject(application: TrailersApplication)

}