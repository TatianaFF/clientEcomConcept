package com.example.ecommerceconcept.presentation.ui.models

import com.example.data.models.cart.CartResponseModel
import com.example.data.models.phones.PhoneResponseModel
import java.io.Serializable

data class PhoneCartModel(
    var cart: CartResponseModel,
    var phone: PhoneResponseModel
): Serializable
