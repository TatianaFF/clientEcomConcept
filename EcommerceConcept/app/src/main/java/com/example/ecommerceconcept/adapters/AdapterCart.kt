package com.example.ecommerceconcept.adapters

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceconcept.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_cart.view.*
import java.util.ArrayList

//class AdapterCart: RecyclerView.Adapter<AdapterCart.CartViewHolder>()  {
//    private var listPhones = emptyList<Basket>()
//    var countPhoneCart: ((Int, Int) -> (Unit))? = null
//    var delCart: ((Int) -> (Unit))? = null
//
//    class CartViewHolder(view: View): RecyclerView.ViewHolder(view)
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterCart.CartViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cart, parent, false)
//        return AdapterCart.CartViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
//        val img = holder.itemView.img_phone_cart
//        val tvTitlePhone = holder.itemView.tv_title_phone_cart
//        val tvPricePhone = holder.itemView.tv_price_phone_cart
//        val btnMinus = holder.itemView.btn_minus
//        val btnPlus = holder.itemView.btn_plus
//        val tvCountPhone = holder.itemView.tv_count_phone
//        val imgDelBasket = holder.itemView.img_del_basket
////        var countPhone = 1
//
//        val phoneCurrent = listPhones[position]
//
//        Picasso.with(img.context).load(phoneCurrent.images).into(img)
//        tvTitlePhone.text = phoneCurrent.title
//        tvPricePhone.text = "\$${phoneCurrent.price}"
//
//        var countCurPhone = phoneCurrent.count
//        tvCountPhone.text = countCurPhone.toString()
//
//        btnMinus.setOnClickListener{
//            if (countCurPhone > 1){
//                countCurPhone--
//                tvCountPhone.text = countCurPhone.toString()
//                Log.e("id_minus", phoneCurrent.id.toString())
//
//                countPhoneCart?.invoke(phoneCurrent.id!!, countCurPhone)
//            }
//        }
//
//        btnPlus.setOnClickListener{
//            countCurPhone++
//            tvCountPhone.text = countCurPhone.toString()
//            Log.e("id_plus", phoneCurrent.id.toString())
//
//            countPhoneCart?.invoke(phoneCurrent.id!!, countCurPhone)
//        }
//
//        imgDelBasket.setOnClickListener{
//            delCart?.invoke(phoneCurrent.id!!)
//        }
//    }
//
//    override fun getItemCount(): Int {
//        return listPhones.size
//    }
//
//    @SuppressLint("NotifyDataSetChanged")
//    fun setListPhones(list: ArrayList<Basket>){
//        listPhones = list
//        notifyDataSetChanged()
//    }
//}