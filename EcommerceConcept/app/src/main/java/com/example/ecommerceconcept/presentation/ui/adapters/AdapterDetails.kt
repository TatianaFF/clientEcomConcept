package com.example.ecommerceconcept.presentation.ui.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.ecommerceconcept.ARG_OBJECT
import com.example.ecommerceconcept.presentation.ui.fragments.detailPhone.DetailFragment

class AdapterDetails(fragment: DetailFragment): FragmentStateAdapter(fragment) {
    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        val fragment = DetailFragment()
        fragment.arguments = Bundle().apply {
            putInt(ARG_OBJECT, position + 1)
        }
        return fragment
    }

}