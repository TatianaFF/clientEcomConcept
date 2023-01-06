package com.example.ecommerceconcept.presentation.ui.fragments.filterFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.Spinner
import androidx.fragment.app.FragmentManager
import com.example.ecommerceconcept.databinding.FragmentFilterBinding

class FilterFragment : Fragment() {

    private lateinit var binding: FragmentFilterBinding
    private lateinit var adapterSpinnerBrand: ArrayAdapter<String>
    private lateinit var adapterSpinnerPrice: ArrayAdapter<String>
    private lateinit var adapterSpinnerSize: ArrayAdapter<String>
    private lateinit var spinnerBrand: Spinner
    private lateinit var spinnerPrice: Spinner
    private lateinit var spinnerSize: Spinner
    private var listBrands = listOf("Samsung", "Motorola", "Xiaomi")
    private var listPrice = listOf("$0 - $1000", "$1000 - $2000", "$2000 - $4000", "$4000 - $7000", "$5000 - $7000", "$7000 - $10000",)
    private var listSize = listOf("4.5 to 5.5 inches", "6.1 to 6.29 inches", "6.3 to 6.49 inches")
    private lateinit var btnCross: ImageButton
    private lateinit var frManager: FragmentManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFilterBinding.inflate(layoutInflater, container, false)

        spinnerBrand = binding.spinnerBrandFilter
        spinnerPrice = binding.spinnerPriceFilter
        spinnerSize = binding.spinnerSizeFilter

        adapterSpinnerBrand = ArrayAdapter(requireActivity(), android.R.layout.simple_spinner_item, listBrands)
        adapterSpinnerPrice = ArrayAdapter(requireActivity(), android.R.layout.simple_spinner_item, listPrice)
        adapterSpinnerSize = ArrayAdapter(requireActivity(), android.R.layout.simple_spinner_item, listSize)

        adapterSpinnerBrand.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapterSpinnerPrice.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapterSpinnerSize.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerBrand.adapter = adapterSpinnerBrand
        spinnerPrice.adapter = adapterSpinnerPrice
        spinnerSize.adapter = adapterSpinnerSize

        btnCross = binding.crossFilter

        frManager = requireActivity().supportFragmentManager

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        btnCross.setOnClickListener {
            frManager.beginTransaction().remove(this).commit()

        }

    }

}