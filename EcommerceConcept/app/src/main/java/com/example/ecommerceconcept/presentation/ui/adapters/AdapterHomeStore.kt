package com.example.ecommerceconcept.presentation.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceconcept.R
import com.example.data.models.holders.HomeStoreHolderModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_home_store.view.*

class AdapterHomeStore: RecyclerView.Adapter<AdapterHomeStore.HomeStoreViewHolder>() {

    private var listHomeStore = emptyList<HomeStoreHolderModel>()

    class HomeStoreViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeStoreViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home_store, parent, false)
        return HomeStoreViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeStoreViewHolder, position: Int) {
        val brand = holder.itemView.tv_brand
        val description = holder.itemView.tv_description
        val img = holder.itemView.img_home_store
        val new = holder.itemView.tv_is_new

        val homeStoreCurrent = listHomeStore[position]
//        img.setImageDrawable(homeStoreCurrent.image)
        Picasso.get()
            .load(homeStoreCurrent.image)
            .into(img)

        brand.text = homeStoreCurrent.brand
        description.text = homeStoreCurrent.description

        if (!homeStoreCurrent.is_new) new.text = ""
    }

    override fun getItemCount(): Int {
        return listHomeStore.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setListHomeStore(list: ArrayList<HomeStoreHolderModel>){
        listHomeStore = list
        notifyDataSetChanged()
    }
}