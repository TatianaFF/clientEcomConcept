package com.example.ecommerceconcept.presentation.ui.adapters

import android.annotation.SuppressLint
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceconcept.R
import com.example.ecommerceconcept.presentation.ui.fragments.mainFragment.MainFragment
import com.example.models.holders.BestSellerHolderModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_best_seller.view.*

class AdapterBestSeller(): RecyclerView.Adapter<AdapterBestSeller.BestSellerViewHolder>() {
    private var listBestSeller = emptyList<BestSellerHolderModel>()
    private var listIdFavorite = emptyList<Int>()
    var addFavorite: ((BestSellerHolderModel, Boolean) -> (Unit))? = null


    class BestSellerViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestSellerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_best_seller, parent, false)
        return BestSellerViewHolder(view)
    }

    override fun onBindViewHolder(holder: BestSellerViewHolder, position: Int) {
        val img = holder.itemView.img_best_seller
        val priceDiscount = holder.itemView.tv_price_discount
        val priceWithoutDiscount = holder.itemView.tv_price_without_discount
        val title = holder.itemView.tv_title
        val favorite = holder.itemView.floating_favorite

        val bestSellerCurrent = listBestSeller[position]

        priceDiscount.text = "\$${bestSellerCurrent.discount_price}"
        priceWithoutDiscount.text = "\$${bestSellerCurrent.price_without_discount}"
        priceWithoutDiscount.paintFlags = priceDiscount.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        title.text = bestSellerCurrent.title

        Picasso.get()
            .load(bestSellerCurrent.picture)
            .into(img)

        favorite.tag = position
//        favorite.setOnClickListener{ v ->
//            val curPos = v.tag as Int
//            val curPhone = listBestSeller[curPos]
//            var isClick = false
//            if (!listIdFavorite.contains(curPhone.id)) isClick = true
//            favorite.isClickable = isClick
//
//            bestSellerCurrent.id?.let {
//                addFavorite?.invoke(curPhone, isClick)
//            }
//        }
    }

    override fun getItemCount(): Int {
        return listBestSeller.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setListBestSeller(list: ArrayList<BestSellerHolderModel>){
        listBestSeller = list
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setListIdFavorite(list: ArrayList<Int>){
        listIdFavorite = list
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: BestSellerViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener {
            MainFragment.clickPhone(listBestSeller[holder.adapterPosition].id)
        }
    }
}