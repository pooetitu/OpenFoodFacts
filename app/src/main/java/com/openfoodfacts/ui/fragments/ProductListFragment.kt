package com.openfoodfacts.ui.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.openfoodfacts.R
import com.openfoodfacts.models.Nutriscore
import com.openfoodfacts.models.NutritionFacts
import com.openfoodfacts.models.NutritionFactsItem
import com.openfoodfacts.Product
import com.openfoodfacts.ui.ProductListAdapter
import kotlinx.android.synthetic.main.fragment_product_list.*


class ProductListFragment : Fragment() {
    companion object {
        const val SCAN_BAR_CODE = 1
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        parent: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_product_list, parent, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        products_start_scan.setOnClickListener {
            val intent = Intent()
            intent.action = "com.google.zxing.client.android.SCAN"
            intent.putExtras(bundleOf("SCAN_FORMATS" to "EAN_13"))
            startActivityForResult(intent, SCAN_BAR_CODE)
        }
        products_list.run {
            layoutManager = LinearLayoutManager(this@ProductListFragment.context)
            adapter = ProductListAdapter()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == SCAN_BAR_CODE && resultCode == Activity.RESULT_OK) {
            val scanResult = data?.getStringExtra("SCAN_RESULT")
            if (scanResult != null) {
                val product = Product(
                    "Petit pois et carottes",
                    "Cassegrain",
                    scanResult,
                    Nutriscore.B,
                    "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg",
                    "400 g (280 g net égoutté)",
                    listOf("France", "Japon", "Suisse"),
                    listOf(
                        "Petits pois 66%",
                        "eau",
                        "garniture 2,8%",
                        "(salade, oignon grelot)",
                        "sucre",
                        "sel",
                        "arôme naturel"
                    ),
                    listOf("Aucune"),
                    listOf("Aucun"),
                    NutritionFacts(
                        NutritionFactsItem("kj", 293f, 293f),
                        NutritionFactsItem("g", 0.8f, 0.8f),
                        NutritionFactsItem("g", 0.1f, 0.1f),
                        NutritionFactsItem("g", 8.4f, 8.4f),
                        NutritionFactsItem("g", 5.2f, 5.2f),
                        NutritionFactsItem("g", 5.2f, 5.2f),
                        NutritionFactsItem("g", 4.8f, 4.8f),
                        NutritionFactsItem("g", 0.75f, 0.75f),
                        NutritionFactsItem("g", 0.295f, 0.295f)
                    )
                )
                val bundle = bundleOf("product" to product)
                findNavController().navigate(R.id.display_product_details, bundle)
            }
        }
    }
}