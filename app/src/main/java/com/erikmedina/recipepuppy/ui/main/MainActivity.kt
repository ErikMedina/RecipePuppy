package com.erikmedina.recipepuppy.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.erikmedina.recipepuppy.R

class MainActivity : AppCompatActivity(), MainView {

    private val mPresenter: MainPresenter = MainPresenterImpl(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mPresenter.searchRecipes("chicken")
    }

    override fun populateRecipes() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
