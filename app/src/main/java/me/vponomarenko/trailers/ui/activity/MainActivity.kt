package me.vponomarenko.trailers.ui.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import me.vponomarenko.trailers.R
import me.vponomarenko.trailers.router.base.INavigator
import me.vponomarenko.trailers.ui.fragment.MainFragment
import javax.inject.Inject

/**
 * Author: Valery Ponomarenko
 * Date: 03/02/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    protected lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    protected lateinit var navigator: INavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, MainFragment.newInstance())
                    .addToBackStack(null)
                    .commit()
        }
    }

    override fun onBackPressed() {
        navigator.onBackPressed()
    }

    override fun supportFragmentInjector() = fragmentInjector

}