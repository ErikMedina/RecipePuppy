package com.erikmedina.recipepuppy.ui.searchable.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.erikmedina.recipepuppy.R
import com.erikmedina.recipepuppy.model.recipe.Recipe

/**
 * Adapter for recipes
 */
class RecipesAdapter : RecyclerView.Adapter<RecipesAdapter.ViewHolder>() {

    private var mRecipes = mutableListOf<Recipe>()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_recipe, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.title?.text = mRecipes[position].title
        holder?.ingredients?.text = mRecipes[position].ingredients
        holder?.href?.text = mRecipes[position].href
        //TODO: load image
    }

    override fun getItemCount() = mRecipes.size

    fun setRecipes(recipes: List<Recipe>) {
        mRecipes = recipes as MutableList<Recipe>
        notifyDataSetChanged()
    }

    fun clear() {
        mRecipes.clear()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var title = itemView.findViewById<TextView>(R.id.recipe_title)
        var ingredients = itemView.findViewById<TextView>(R.id.recipe_ingredients)
        var href = itemView.findViewById<TextView>(R.id.recipe_href)
        var thumbnail = itemView.findViewById<ImageView>(R.id.recipe_image)
    }
}
