package me.vponomarenko.trailers.extension

import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar

/**
 * Author: Valery Ponomarenko
 * Date: 13/02/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */
 
fun Fragment.installToolbar(toolbar: Toolbar, @StringRes title: Int) {
    (activity as? AppCompatActivity)?.apply {
        setSupportActionBar(toolbar)
        supportActionBar?.setTitle(title)
    }
}