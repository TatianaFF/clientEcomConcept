package com.example.ecommerceconcept

import android.content.SharedPreferences
import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.ecommerceconcept.databinding.ActivityMainBinding
import com.example.ecommerceconcept.models.cart.CartRequestModel
import com.example.ecommerceconcept.models.cart.CartResponseModel
import com.example.ecommerceconcept.models.phones.PhoneRequestModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
    lateinit var navView: BottomNavigationView
    private val viewModel: MainActivityViewModel by viewModels()
    var allCart = emptyList<CartResponseModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navView = binding.navView
        APP = this

        val policy = ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        navigation()
        badgeCart()

    }

    override fun onResume() {
        super.onResume()

    }

    private fun navigation(){
        navController = Navigation.findNavController(this, R.id.nav_fragment)

        navView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.navigation_explorer -> {
                    navController.navigate(R.id.mainFragment)
                }
                R.id.navigation_cart -> {
                    navController.navigate(R.id.cartFragment)
                }
                R.id.navigation_favorite -> {
                    navController.navigate(R.id.favoriteFragment)
                }
                R.id.navigation_person -> {
                    navController.navigate(R.id.personFragment)
                }
            }
            true
        }
    }

    private fun badgeCart(){
        viewModel.getCart().observe(this){ listCart ->
            Log.e("getCart", listCart.size.toString())

            var countProduct = 0
            listCart.forEach { countProduct += it.count }
            navView.getOrCreateBadge(R.id.navigation_cart).number = countProduct
        }
//        viewModel.getCartsByIdUser(idUserConst).observe(this){ listCart ->
//            allCart=listCart
//            Log.e("getCartsByIdUser", listCart.size.toString())
//
//            var countProduct = 0
//            listCart.forEach { countProduct += it.count }
//            navView.getOrCreateBadge(R.id.navigation_cart).number = countProduct
//        }
    }
}