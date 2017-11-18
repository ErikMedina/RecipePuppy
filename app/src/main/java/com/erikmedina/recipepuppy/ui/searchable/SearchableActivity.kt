package com.erikmedina.recipepuppy.ui.searchable

import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.erikmedina.recipepuppy.R


class SearchableActivity : AppCompatActivity(), SearchableView {

    private val mPresenter: SearchablePresenter = SearchablePresenterImpl(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "[onCreate]")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_searchable)

        handleIntent(intent)

    }

    override fun onNewIntent(intent: Intent) {
        setIntent(intent)
        handleIntent(intent)
    }

    private fun handleIntent(intent: Intent) {
        if (Intent.ACTION_SEARCH == intent.action) {
            val query = intent.getStringExtra(SearchManager.QUERY)
            if (query != null) {
                mPresenter.searchRecipes(query)
            }
        }
    }

    override fun populateRecipes() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        const val TAG = "SearchableActivity"
    }
}
