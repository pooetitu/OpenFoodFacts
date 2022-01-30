package com.openfoodfacts.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.openfoodfacts.R
import com.openfoodfacts.models.Nutriscore
import com.openfoodfacts.models.NutritionFacts
import com.openfoodfacts.models.NutritionFactsItem
import com.openfoodfacts.Product
import kotlinx.android.synthetic.main.product.view.*


class ProductListAdapter : RecyclerView.Adapter<ListItemCell>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemCell {
        return ListItemCell(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.product, parent, false)
        )
    }

    override fun onBindViewHolder(cell: ListItemCell, position: Int) {
        val product = Product(
            "Petit pois et carottes",
            "Cassegrain",
            "3083680085304",
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
        cell.itemView.setOnClickListener {
            cell.itemView.findNavController().navigate(R.id.display_product_details, bundle)
        }

        cell.image.setImageDrawable(
            ContextCompat.getDrawable(
                cell.image.context,
                R.drawable.placeholder
            )
        )
        cell.name.text = product.name
        cell.brand.text = product.brand
        cell.nutriscore.text =
            cell.itemView.context.getString(R.string.nutriscore, product.nutriscore.name)
        cell.calories.text = cell.itemView.context.getString(
            R.string.calories_per_portion,
            product.nutritionFacts.energy.quantityPerPortion
        )
    }

    override fun getItemCount(): Int {
        return 10
    }

}

class ListItemCell(v: View) : RecyclerView.ViewHolder(v) {

    val image: ImageView = v.dishImage
    val name: TextView = v.product_name
    val brand: TextView = v.product_brand
    val nutriscore: TextView = v.product_nutriscore
    val calories: TextView = v.product_calories

}
