package me.vponomaren.trailers.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import me.vponomaren.trailers.R
import me.vponomaren.trailers.ui.fragment.PlayerFragment

/**
 * Author: Valery Ponomarenko
 * Date: 03/02/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, PlayerFragment.newInstance())
                    .addToBackStack(null)
                    .commit()
        }
    }

}