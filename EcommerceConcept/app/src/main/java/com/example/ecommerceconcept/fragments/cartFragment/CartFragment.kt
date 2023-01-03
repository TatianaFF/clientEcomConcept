package com.example.ecommerceconcept.fragments.cartFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceconcept.databinding.FragmentCartBinding
import com.example.ecommerceconcept.models.cart.CartRequestModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CartFragment : Fragment() {

    private lateinit var binding: FragmentCartBinding
    private val viewModel: CartViewModel by viewModels()
    private lateinit var totalPrice: TextView
    private lateinit var delivery: TextView
//    private var adapterCart = AdapterCart()
    private lateinit var rvCart: RecyclerView
    private lateinit var btnArrowBack: ImageButton
    private lateinit var allCart: List<CartRequestModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(layoutInflater, container, false)

        totalPrice = binding.tvTotal
        delivery = binding.tvDelivery

        rvCart = binding.rvPhonesCart
//        rvCart.adapter = adapterCart

        btnArrowBack = binding.arrowCart



        return binding.root
    }

    override fun onResume() {
        super.onResume()

//        allCart = APP.allCart
//        Log.e("ALLCART", allCart.size.toString())

//        init()

//        adapterCart.countPhoneCart = { idBasket, count ->
//            Log.e("CartFrOnResume", "$idBasket")
//
//            allCart.forEach { cart ->
//                Log.e("before", cart.toString())
//                if (cart.idPhone == idBasket){
//                    cart.count = count
//                    viewModel.updateCart(cart)
//                }
//            }
//
//            allCart.forEach{ Log.e("after", it.toString()) }
//
//        }

//        adapterCart.delCart = { idPhone ->
//            Log.e("idPhone", idPhone.toString())
//            allCart.forEach { cart ->
//                Log.e("before", cart.toString())
//                if (cart.idPhone == idPhone){
//                    viewModel.deleteCart(cart)
//                }
//            }
//            allCart.forEach{ Log.e("after", it.toString()) }
//        }

    }

//    private fun init(){
//
//        viewModel.getAllCart().observe(viewLifecycleOwner){ listCart ->
//            val listBasketPhones = ArrayList<Basket>()
//
//            Log.e("listCart", listCart.size.toString())
//
//            var total = 0.0
//
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
//        }
//
//        btnArrowBack.setOnClickListener {
//            APP.navController.navigate(R.id.mainFragment)
//        }
//
//
//    }

//    private fun telModelToBasket(telModel: TelModel, count: Int): Basket{
//        return Basket(
//            id = telModel.id,
//            images = telModel.picture,
//            price = telModel.price,
//            title = telModel.title,
//            count = count
//        )
//    }

}