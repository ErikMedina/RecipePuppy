package com.erikmedina.recipepuppy.ui.base

import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View

/**
 * Created by erik on 11/19/17.
 */
abstract class BaseActivity : AppCompatActivity(), PresenterView {

    override fun showError(error: String?) {
        val rootView = window.decorView.findViewById<View>(android.R.id.content)
        Snackbar.make(rootView, error.toString(), Snackbar.LENGTH_SHORT).show()
    }
}
