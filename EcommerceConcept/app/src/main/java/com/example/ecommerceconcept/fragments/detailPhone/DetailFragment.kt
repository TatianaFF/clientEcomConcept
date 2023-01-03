package com.example.ecommerceconcept.fragments.detailPhone

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.os.Parcel
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.ecommerceconcept.APP
import com.example.ecommerceconcept.R
import com.example.ecommerceconcept.adapters.AdapterDetails
import com.example.ecommerceconcept.adapters.AdapterImagesPhone
import com.example.ecommerceconcept.databinding.FragmentDetailBinding
import com.example.ecommerceconcept.idUserConst
import com.example.ecommerceconcept.models.cart.CartRequestModel
import com.example.ecommerceconcept.models.favorites.FavoriteRequestModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.roundToInt

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private val TAG = "DetailFragment"
    private lateinit var binding: FragmentDetailBinding
    private val viewModel: DetailViewModel by viewModels()
    private lateinit var btnBack: ImageButton
    private var adapterImagesPhone = AdapterImagesPhone()
    private lateinit var rvImagesPhone: RecyclerView
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private val tabTitleDetail: Array<String> = arrayOf("Shop", "Details", "Features")
    private lateinit var adapterDetails: AdapterDetails
    private lateinit var tvCPU: TextView
    private lateinit var tvCamera: TextView
    private lateinit var tvSSD: TextView
    private lateinit var btnColor1: ImageButton
    private lateinit var btnColor2: ImageButton
    private lateinit var btnAddToCart: Button
    private lateinit var tvBrand: TextView
    private lateinit var imgStar1: ImageView
    private lateinit var imgStar2: ImageView
    private lateinit var imgStar3: ImageView
    private lateinit var imgStar4: ImageView
    private lateinit var imgStar5: ImageView
//    lateinit var samsungObj: DetailSamsung
    private lateinit var btnFavorite: ImageButton
    private var currentIdPhone: String? = null
    private lateinit var btnCap1: Button
    private lateinit var btnCap2: Button
    private lateinit var btnCap3: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)

        currentIdPhone = arguments?.getString("idPhone") as String


        btnBack = binding.btnBack
        rvImagesPhone = binding.rvDetail
        rvImagesPhone.adapter = adapterImagesPhone

        adapterDetails = AdapterDetails(this)

        viewPager = binding.pagerDetail
        viewPager.adapter = adapterDetails

        tabLayout = binding.tabDetail

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabTitleDetail[position]
        }.attach()

        tvCPU = binding.tvCpuDetails
        tvCamera = binding.tvCameraDetails
        tvSSD = binding.tvSsdDetails

        btnColor1 = binding.btnColor1
        btnColor2 = binding.btnColor2

        btnAddToCart = binding.btnAddToCart

        tvBrand = binding.tvBrandDetail

        imgStar1 = binding.star1
        imgStar2 = binding.star2
        imgStar3 = binding.star3
        imgStar4 = binding.star4
        imgStar5 = binding.star5

        btnFavorite = binding.btnFavorite

        btnCap1 = binding.btnCapacity1
        btnCap2 = binding.btnCapacity2
        btnCap3 = binding.btnCapacity3


        return binding.root
    }

    override fun onResume() {
        super.onResume()

        init()
    }

    @SuppressLint("SetTextI18n")
    private fun init(){
        currentIdPhone?.let {
            viewModel.getPhoneById(currentIdPhone!!).observe(viewLifecycleOwner){ currentPhone ->
                Log.e("current phone", currentPhone.toString())

                viewModel.getBestSellerById(currentIdPhone!!).observe(viewLifecycleOwner){ bestseller ->
                    Log.e("current bestseller", bestseller.toString())

                    adapterImagesPhone.setListImagesPhone(currentPhone.images as ArrayList<String>)
                    tvBrand.text = currentPhone.title
                    val rating = currentPhone.rating?.roundToInt()
                    if (rating != null) {
                        ratingVisibilityStars(rating)
                    }
                    tvCPU.text = currentPhone.CPU
                    tvCamera.text = currentPhone.camera
                    tvSSD.text = currentPhone.ssd
                    btnColor1.setBackgroundColor(Color.parseColor(currentPhone.color[0]))
                    btnColor2.setBackgroundColor(Color.parseColor(currentPhone.color[1]))
                    btnAddToCart.text = "Add to Cart      \$${bestseller.discountPrice}"

                    val listCapasity = listOf(btnCap1, btnCap2, btnCap3)
                    var count = 0
                    while (count < currentPhone.capacity.size) {
                        val btn = listCapasity[count]
                        btn.visibility = View.VISIBLE
                        btn.text = currentPhone.capacity[count]
                        count++
                    }

                }

                btnAddToCart.setOnClickListener {
                    viewModel.insertCart(
                        CartRequestModel(
                            idUser = idUserConst,
                            idPhone = currentPhone.id
                        )
                    )
                    btnAddToCart.isClickable = false
                }

                btnFavorite.setOnClickListener {
                    viewModel.insertFavorite(
                        FavoriteRequestModel(
                            idUser = idUserConst,
                            idPhone = currentPhone.id
                        )
                    )
                    btnFavorite.setColorFilter(Color.parseColor("#FF6E4E"))
                }

            }

            btnBack.setOnClickListener{
                APP.navController.navigate(R.id.mainFragment)
            }
        }



    }

    private fun ratingVisibilityStars(rating: Int){
        val listStars = listOf(imgStar1, imgStar2, imgStar3, imgStar3, imgStar4, imgStar5)
        var count = 0
        while (count <= rating) {
            listStars[count].visibility = View.VISIBLE
            count++
        }
    }
}