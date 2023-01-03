package com.example.ecommerceconcept.fragments.cartFragment

import androidx.lifecycle.*
import com.example.ecommerceconcept.db.retroData.MainRemoteData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val mainRemoteData: MainRemoteData
): ViewModel() {


}