package com.example.api

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MyAdapter(val context: Activity, private val productArrayList: List<Product>):
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.eachitem, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return productArrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = productArrayList[position]
        holder.hTitle.text = currentItem.title
        Picasso.get().load(currentItem.thumbnail).into(holder.hImage)
        holder.hRatingNumber.text = currentItem.rating.toString()
        holder.hRatingBar.rating = currentItem.rating.toFloat()
        holder.hPrice.text = "$${currentItem.price}"
        holder.hPriceDiscount.text = "(${currentItem.discountPercentage}% off)"
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val hTitle = itemView.findViewById<TextView>(R.id.productTitle)
        val hImage = itemView.findViewById<ShapeableImageView>(R.id.productImage)
        val hRatingNumber = itemView.findViewById<TextView>(R.id.ratingNumber)
        val hRatingBar = itemView.findViewById<RatingBar>(R.id.ratingBar)
        val hPrice = itemView.findViewById<TextView>(R.id.price)
        val hPriceDiscount = itemView.findViewById<TextView>(R.id.priceDiscount)
    }
}