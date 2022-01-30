package com.openfoodfacts.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.openfoodfacts.R
import com.openfoodfacts.Product
import com.openfoodfacts.utils.ProductModel
import kotlinx.android.synthetic.main.product_details_nav_host.*


class ProductDetailsFragment : Fragment() {
    private val model: ProductModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        parent: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.product_details_nav_host, parent, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val navHost =
            childFragmentManager.findFragmentById(R.id.product_details_nav_host) as NavHostFragment
        NavigationUI.setupWithNavController(product_details_bottom_nav, navHost.navController)

        val product = arguments?.getSerializable("product") as Product
        model.select(product)
    }
}