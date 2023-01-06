package com.example.ecommerceconcept.presentation.ui.fragments.cartFragment

//import com.example.ecommerceconcept.presentation.ui.adapters.AdapterCart
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceconcept.APP
import com.example.ecommerceconcept.R
import com.example.ecommerceconcept.databinding.FragmentCartBinding
import com.example.ecommerceconcept.presentation.ui.adapters.AdapterCart
import com.example.ecommerceconcept.presentation.ui.models.PhoneCartModel
import com.example.idUserConst
import com.example.models.cart.CartRequestUpdateModel
import dagger.hilt.android.AndroidEntryPoint
import java.lang.Exception

@AndroidEntryPoint
class CartFragment : Fragment() {

    private lateinit var binding: FragmentCartBinding
    private val viewModel: CartViewModel by viewModels()
    private lateinit var totalPrice: TextView
    private lateinit var delivery: TextView
    private var adapterCart = AdapterCart()
    private lateinit var rvCart: RecyclerView
    private lateinit var btnArrowBack: ImageButton

//    var updateBadgeCartFragment: ((Int) -> (Unit))? = null

    interface onUpdateBadgeListener {
        fun updateBadge(count: Int)
    }

    lateinit var eventListener: onUpdateBadgeListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            eventListener = context as onUpdateBadgeListener
        } catch (e: Exception) {
            throw ClassCastException(activity.toString() + " must implement onSomeEventListener");
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(layoutInflater, container, false)

        totalPrice = binding.tvTotal
        delivery = binding.tvDelivery
        delivery.text = "Free"

        rvCart = binding.rvPhonesCart
        rvCart.adapter = adapterCart

        btnArrowBack = binding.arrowCart



        return binding.root
    }

    override fun onResume() {
        super.onResume()

        init()

        adapterCart.updateCartCount = { phoneCartModel ->
            Log.e("phoneCartModel_CF", phoneCartModel.toString())

            viewModel.updateCart(
                CartRequestUpdateModel(
                    id = phoneCartModel.cart.id,
                    idUser = phoneCartModel.cart.idUser,
                    idPhone = phoneCartModel.cart.idPhone,
                    count = phoneCartModel.cart.count
                )
            )
//            activity.
        }

        adapterCart.updateBadgeAdapter = {
            eventListener.updateBadge(it)
        }

        adapterCart.delCart = { idCart ->
            viewModel.deleteCart(idCart)
        }

    }

    private fun init(){

        viewModel.getCartsByIdUser(idUserConst).observe(viewLifecycleOwner){ listCart ->

            val listPhoneCartToAdapter = ArrayList<PhoneCartModel>()

            listCart.forEach {
                viewModel.getPhoneById(it.idPhone).observe(viewLifecycleOwner) { phone ->
                    listPhoneCartToAdapter.add(
                        PhoneCartModel(
                            phone = phone,
                            cart = it
                        )
                    )
                    Log.e("size phone", listPhoneCartToAdapter.size.toString())
                    adapterCart.setListPhoneCart(listPhoneCartToAdapter)
                }
            }

//            listCart.forEach { cart ->
//                cart.idPhone?.let {
//                    viewModel.getTelById(it).observe(viewLifecycleOwner){ tel ->
//                        val basket = telModelToBasket(tel, cart.count)
//                        listBasketPhones.add(basket)
//                        Log.e("listBasketPhones", listCart.size.toString())
//                        adapterCart.setListPhones(listBasketPhones)
//
//                        if(basket.count!=0 && basket.price!=0.0) total += basket.count* basket.price!!
//                        totalPrice.text = total.toString()
//
//                        delivery.text = "Free"
//                    }
//                }
//
//            }
        }

        btnArrowBack.setOnClickListener {
            APP.navController.navigate(R.id.mainFragment)
        }


    }

}