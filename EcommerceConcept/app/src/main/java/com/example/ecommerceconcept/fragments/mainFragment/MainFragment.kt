package com.example.ecommerceconcept.fragments.mainFragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.ecommerceconcept.APP
import com.example.ecommerceconcept.R
import com.example.ecommerceconcept.adapters.AdapterBestSeller
import com.example.ecommerceconcept.adapters.AdapterCategory
import com.example.ecommerceconcept.adapters.AdapterHomeStore
import com.example.ecommerceconcept.databinding.FragmentMainBinding
import com.example.ecommerceconcept.models.bestSellers.BestSellersRequestModel
import com.example.ecommerceconcept.models.cart.CartRequestModel
import com.example.ecommerceconcept.models.favorites.FavoriteRequestModel
import com.example.ecommerceconcept.models.holders.BestSellerHolderModel
import com.example.ecommerceconcept.models.holders.HomeStoreHolderModel
import com.example.ecommerceconcept.models.hotSales.HotSalesRequestModel
import com.example.ecommerceconcept.models.phones.PhoneRequestModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

//генерация классов Component. Каждый компонент отвечает за зависимости своего класса
@AndroidEntryPoint
class MainFragment : Fragment() {

    private val TAG = "MainFragment"
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: FragmentMainBinding
    private var adapterHomeStore = AdapterHomeStore()
    private var adapterBestSeller = AdapterBestSeller()
    private val idSamsung = 101
    private lateinit var recyclerViewHomeStore: RecyclerView
    private lateinit var recyclerViewBestSeller: RecyclerView
    private lateinit var samsungObject: PhoneRequestModel
    private lateinit var tvSeeMoreHot: TextView
    private lateinit var tvSeeMoreBest: TextView
    private lateinit var adapterCategory: AdapterCategory
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private val tabTitleCategory: Array<String> = arrayOf("Phones", "Computer", "Health", "Books", "Books", "Books")
    private val tabIconsCategory: Array<Int> = arrayOf(
        R.drawable.ic_phones,
        R.drawable.ic_computer,
        R.drawable.ic_helth,
        R.drawable.ic_books,
        R.drawable.ic_books,
        R.drawable.ic_books
    )
    private var listCities = arrayListOf("Moscow", "Krasnoyarsk", "Krasnodar", "Volgograd", "Novosibirsk")
    private lateinit var adapterCity: ArrayAdapter<String>
    private lateinit var spinerCity: Spinner
    private lateinit var imgFilter: ImageView
    private lateinit var linearFilterConteiner: LinearLayout
    private lateinit var frManager: FragmentManager
    private val tagFilterFragment = "FilterFragment"
    private lateinit var imgQR: ImageView
//    private var mediatorLiveData = MediatorLiveData<>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)

        recyclerViewHomeStore = binding.rvHomeStore
        recyclerViewHomeStore.adapter = adapterHomeStore

        recyclerViewBestSeller = binding.rvBestSeller
        recyclerViewBestSeller.adapter = adapterBestSeller

        tvSeeMoreHot = binding.tvSeeMoreHot
        tvSeeMoreBest = binding.tvSeeMoreBest

        adapterCategory = AdapterCategory(this)

        viewPager = binding.pager
        viewPager.adapter = adapterCategory

        tabLayout = binding.tablayoutCategory

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabTitleCategory[position]
            tab.setIcon(tabIconsCategory[position])
        }.attach()

        spinerCity = binding.spinnerCity

        adapterCity = ArrayAdapter(requireActivity(), android.R.layout.simple_spinner_item, listCities)

        adapterCity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinerCity.adapter = adapterCity

        imgFilter = binding.imgFilter

        linearFilterConteiner = binding.linearFilterConteiner

        frManager = requireActivity().supportFragmentManager


        imgQR = binding.qrCode

        return binding.root
    }


    override fun onResume() {
        super.onResume()

        viewModel.getHotsales().observe(viewLifecycleOwner){ listHotSales ->
            val listHomStoreHolder = ArrayList<HomeStoreHolderModel>()
            listHotSales.forEach {
                viewModel.getPhoneById(it.idPhone).observe(viewLifecycleOwner){ phone ->

                    listHomStoreHolder.add(
                        HomeStoreHolderModel(
                            id = phone.id,
                            is_new = it.isNew,
                            image = it.picture,
                            description = it.subTitle,
                            brand = phone.title
                        )
                    )
                    adapterHomeStore.setListHomeStore(listHomStoreHolder)
                }
            }

        }

        viewModel.getBestsellers().observe(viewLifecycleOwner){ listBestSellers ->
            val listBestSellersHolder = ArrayList<BestSellerHolderModel>()
            listBestSellers.forEach {
                viewModel.getPhoneById(it.idPhone).observe(viewLifecycleOwner){ phone ->
                    listBestSellersHolder.add(
                        BestSellerHolderModel(
                            id = phone.id,
                            discount_price = it.discountPrice,
                            picture = phone.images[0],
                            price_without_discount = phone.price,
                            title = phone.title
                        )
                    )
                    adapterBestSeller.setListBestSeller(listBestSellersHolder)
                }
            }
        }
    }


    companion object{
        fun clickPhone(idPhone: String){
            val bundle = Bundle()
            bundle.putString("idPhone", idPhone)

            APP.navController.navigate(R.id.detailFragment, bundle)
        }
    }
}


