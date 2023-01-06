package com.example.ecommerceconcept.presentation.ui.adapters

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceconcept.R
import com.example.ecommerceconcept.presentation.ui.models.PhoneCartModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_cart.view.*

class AdapterCart: RecyclerView.Adapter<AdapterCart.CartViewHolder>()  {
    private var listPhoneCart = emptyList<PhoneCartModel>()

    var delCart: ((String) -> (Unit))? = null
    var updateCartCount: ((PhoneCartModel) -> (Unit))? = null
    var updateBadgeAdapter: ((Int) -> (Unit))? = null

    class CartViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterCart.CartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cart, parent, false)
        return AdapterCart.CartViewHolder(view)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val img = holder.itemView.img_phone_cart
        val tvTitlePhone = holder.itemView.tv_title_phone_cart
        val tvPricePhone = holder.itemView.tv_price_phone_cart
        val btnMinus = holder.itemView.btn_minus
        val btnPlus = holder.itemView.btn_plus
        val tvCountPhone = holder.itemView.tv_count_phone
        val imgDelCart = holder.itemView.img_del_basket

        val phoneCartCurrent = listPhoneCart[position]

        Picasso.get()
            .load(phoneCartCurrent.phone.images[0])
            .into(img)

        tvTitlePhone.text = phoneCartCurrent.phone.title
        tvPricePhone.text = "\$${phoneCartCurrent.phone.price}"

        var countPhoneInCart = phoneCartCurrent.cart.count
        tvCountPhone.text = countPhoneInCart.toString()

//        tvCountPhone.text = countCurPhone.toString()

        btnMinus.setOnClickListener{
            if (countPhoneInCart > 1){
                countPhoneInCart--
                tvCountPhone.text = countPhoneInCart.toString()
                phoneCartCurrent.cart.count = countPhoneInCart
                updateCartCount?.invoke(phoneCartCurrent)


                var countB = 0
                listPhoneCart.forEach {
                    if (it.phone.id != phoneCartCurrent.phone.id) {
                        countB+=it.cart.count
                    }
                }
                countB+=countPhoneInCart
                updateBadgeAdapter?.invoke(countB)
                Log.e("adapter_minus", countB.toString())

                notifyDataSetChanged()

                Log.e("id_minus", phoneCartCurrent.phone.id)
            }
        }

        btnPlus.setOnClickListener{
            countPhoneInCart++
            tvCountPhone.text = countPhoneInCart.toString()
            phoneCartCurrent.cart.count = countPhoneInCart
            updateCartCount?.invoke(phoneCartCurrent)

            var countB = 0
            listPhoneCart.forEach {
                if (it.phone.id != phoneCartCurrent.phone.id) {
                    countB+=it.cart.count
                }
            }
            countB+=countPhoneInCart
            updateBadgeAdapter?.invoke(countB)
            Log.e("adapter_plus", countB.toString())

            notifyDataSetChanged()

            Log.e("id_plus", phoneCartCurrent.phone.id)
        }

        imgDelCart.setOnClickListener{
            delCart?.invoke(phoneCartCurrent.cart.id)
        }
    }

    override fun getItemCount(): Int {
        return listPhoneCart.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setListPhoneCart(list: ArrayList<PhoneCartModel>){
        listPhoneCart = list
        notifyDataSetChanged()
    }
}