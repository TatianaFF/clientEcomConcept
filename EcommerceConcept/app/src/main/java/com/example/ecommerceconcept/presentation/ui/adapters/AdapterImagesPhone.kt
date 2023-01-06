package com.example.ecommerceconcept.presentation.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceconcept.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_image_phone.view.*

class AdapterImagesPhone: RecyclerView.Adapter<AdapterImagesPhone.ImagesPhoneViewHolder>()  {
    private var listImagesPhone = emptyList<String>()

    class ImagesPhoneViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesPhoneViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_image_phone, parent, false)
        return ImagesPhoneViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImagesPhoneViewHolder, position: Int) {
        val img = holder.itemView.img_phone_detail

        val imagesPhoneCurrent = listImagesPhone[position]

        Picasso.get()
            .load(imagesPhoneCurrent)
            .into(img)
//        Picasso.with(img.context).load(imagesPhoneCurrent).into(img)

    }

    override fun getItemCount(): Int {
        return listImagesPhone.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setListImagesPhone(list: ArrayList<String>){
        listImagesPhone = list
        notifyDataSetChanged()
    }
}