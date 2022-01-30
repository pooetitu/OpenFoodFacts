package com.openfoodfacts.utils

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.openfoodfacts.Product

class ProductModel : ViewModel() {
    private val selected = MutableLiveData<Product>()

    fun select(product: Product) {
        selected.value = product
    }
    fun getSelected(): MutableLiveData<Product> {
        return selected
    }
}