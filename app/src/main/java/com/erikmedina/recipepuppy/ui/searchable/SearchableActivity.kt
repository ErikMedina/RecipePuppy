package com.erikmedina.recipepuppy.ui.searchable

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.Menu
import android.widget.ProgressBar
import android.widget.SearchView
import com.erikmedina.recipepuppy.R
import com.erikmedina.recipepuppy.model.recipe.Recipe
import com.erikmedina.recipepuppy.ui.searchable.adapter.RecipesAdapter


class SearchableActivity : AppCompatActivity(), SearchableView {

    private val mPresenter = SearchablePresenterImpl(this)
    private val mAdapter = RecipesAdapter(this)

    private lateinit var mRecycler: RecyclerView
    private lateinit var mProgress: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "[onCreate]")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_searchable)

        mRecycler = findViewById(R.id.recycler)
        mProgress = findViewById(R.id.progress)
        mRecycler.adapter = mAdapter
        mRecycler.layoutManager = LinearLayoutManager(this)
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the options menu from XML
        val inflater = menuInflater
        inflater.inflate(R.menu.options_menu, menu)

        // Get the SearchView and set the searchable configuration
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu.findItem(R.id.menu_search).actionView as SearchView
        // Assumes current activity is the searchable activity
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.setIconifiedByDefault(false) // Do not iconify the widget; expand it by default

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {

                return false
            }
        })
        return true
    }

    override fun setRecipes(recipes: MutableList<Recipe>) {
        mAdapter.setRecipes(recipes)
    }

    companion object {
        const val TAG = "SearchableActivity"
    }
}
