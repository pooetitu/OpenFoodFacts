package com.openfoodfacts.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.openfoodfacts.R
import com.openfoodfacts.Product
import com.openfoodfacts.utils.ProductModel
import kotlinx.android.synthetic.main.fragment_details_nutritional_values.*

class ProductDetailsNutritionalValuesFragment : Fragment() {
    private val model: ProductModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        parent: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details_nutritional_values, parent, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val product = model.getSelected().value as Product
        energy_per_100g.text = getString(
            R.string.energy_display,
            product.nutritionFacts.energy.quantityPerHundredGram,
            product.nutritionFacts.energy.unit
        )
        fat_per_100g.text = getString(
            R.string.fat_display,
            product.nutritionFacts.fat.quantityPerHundredGram,
            product.nutritionFacts.fat.unit
        )
        saturated_fat_per_100g.text = getString(
            R.string.saturated_fat_display,
            product.nutritionFacts.saturatedFatAcid.quantityPerHundredGram,
            product.nutritionFacts.saturatedFatAcid.unit
        )
        carbohydrate_per_100g.text = getString(
            R.string.carbohydrate_display,
            product.nutritionFacts.carbohydrate.quantityPerHundredGram,
            product.nutritionFacts.carbohydrate.unit
        )
        sugar_per_100g.text = getString(
            R.string.sugar_display,
            product.nutritionFacts.sugar.quantityPerHundredGram,
            product.nutritionFacts.sugar.unit
        )
        fibers_per_100g.text = getString(
            R.string.fibers_display,
            product.nutritionFacts.fibers.quantityPerHundredGram,
            product.nutritionFacts.fibers.unit
        )
        proteins_per_100g.text = getString(
            R.string.proteins_display,
            product.nutritionFacts.proteins.quantityPerHundredGram,
            product.nutritionFacts.proteins.unit
        )
        salt_per_100g.text = getString(
            R.string.salt_display,
            product.nutritionFacts.salt.quantityPerHundredGram,
            product.nutritionFacts.salt.unit
        )
        sodium_per_100g.text = getString(
            R.string.sodium_display,
            product.nutritionFacts.sodium.quantityPerHundredGram,
            product.nutritionFacts.sodium.unit
        )

        energy_per_portion.text = getString(
            R.string.energy_display,
            product.nutritionFacts.energy.quantityPerPortion,
            product.nutritionFacts.energy.unit
        )
        fat_per_portion.text = getString(
            R.string.fat_display,
            product.nutritionFacts.fat.quantityPerPortion,
            product.nutritionFacts.fat.unit
        )
        saturated_fat_per_portion.text = getString(
            R.string.saturated_fat_display,
            product.nutritionFacts.saturatedFatAcid.quantityPerPortion,
            product.nutritionFacts.saturatedFatAcid.unit
        )
        carbohydrate_per_portion.text = getString(
            R.string.carbohydrate_display,
            product.nutritionFacts.carbohydrate.quantityPerPortion,
            product.nutritionFacts.carbohydrate.unit
        )
        sugar_per_portion.text = getString(
            R.string.sugar_display,
            product.nutritionFacts.sugar.quantityPerPortion,
            product.nutritionFacts.sugar.unit
        )
        fibers_per_portion.text = getString(
            R.string.fibers_display,
            product.nutritionFacts.fibers.quantityPerPortion,
            product.nutritionFacts.fibers.unit
        )
        proteins_per_portion.text = getString(
            R.string.proteins_display,
            product.nutritionFacts.proteins.quantityPerPortion,
            product.nutritionFacts.proteins.unit
        )
        salt_per_portion.text = getString(
            R.string.salt_display,
            product.nutritionFacts.salt.quantityPerPortion,
            product.nutritionFacts.salt.unit
        )
        sodium_per_portion.text = getString(
            R.string.sodium_display,
            product.nutritionFacts.sodium.quantityPerPortion,
            product.nutritionFacts.sodium.unit
        )
    }
}