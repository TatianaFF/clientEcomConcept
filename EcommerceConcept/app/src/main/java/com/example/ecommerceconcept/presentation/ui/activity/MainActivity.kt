package com.example.ecommerceconcept.presentation.ui.activity

import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.ecommerceconcept.APP
import com.example.ecommerceconcept.R
import com.example.ecommerceconcept.databinding.ActivityMainBinding
import com.example.data.models.cart.CartResponseModel
import com.example.ecommerceconcept.presentation.ui.fragments.cartFragment.CartFragment
import com.example.idUserConst
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity(), CartFragment.onUpdateBadgeListener {

    private lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
    lateinit var navView: BottomNavigationView
    private val viewModel: MainActivityViewModel by viewModels()


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
        viewModel.getCartsByIdUser(idUserConst).observe(this){ listCart ->

            var countProduct = 0
            listCart.forEach { countProduct += it.count; Log.e("badgeCart", countProduct.toString())}
            navView.getOrCreateBadge(R.id.navigation_cart).number = countProduct
        }
    }

    override fun updateBadge(count: Int) {
        navView.getOrCreateBadge(R.id.navigation_cart).number = count
//        navView.getOrCreateBadge(R.id.navigation_cart).number = count
    }
}