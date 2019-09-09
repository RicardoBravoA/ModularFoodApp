package com.rba.map

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rba.food.util.diffUtil
import com.rba.food.util.inflate
import com.rba.food.util.loadUrl
import com.rba.model.model.RestaurantModel
import kotlinx.android.synthetic.main.item_restaurant.view.*

class MainAdapter(
    private val onClickRestaurant: (RestaurantModel) -> Unit
) :
    RecyclerView.Adapter<MainAdapter.RestaurantViewHolder>() {

    var list: List<RestaurantModel> by diffUtil(
        emptyList(),
        areItemsTheSame = { old, new -> old.id == new.id }
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder =
        RestaurantViewHolder(parent.inflate(R.layout.item_restaurant, false))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val movie = list[position]
        holder.bind(movie)
        holder.itemView.setOnClickListener { onClickRestaurant(movie) }
    }

    class RestaurantViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        fun bind(restaurantModel: RestaurantModel) {
            itemView.tvTitle.text = restaurantModel.name
            itemView.tvCuisine.text = restaurantModel.cuisines
            itemView.tvRating.text = restaurantModel.popularity
            itemView.ivRestaurant.loadUrl(restaurantModel.thumb)
        }
    }
}