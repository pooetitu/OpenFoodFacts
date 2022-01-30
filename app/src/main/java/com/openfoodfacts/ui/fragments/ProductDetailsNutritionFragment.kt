package com.openfoodfacts.ui.fragments

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.drawable.DrawableCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.openfoodfacts.R
import com.openfoodfacts.models.NutrientLevel
import com.openfoodfacts.Product
import com.openfoodfacts.utils.ProductModel
import com.pierre.ebrahim.openfoodfacts.R
import kotlinx.android.synthetic.main.fragment_details_nutrition.*

class ProductDetailsNutritionFragment : Fragment() {
    private val model: ProductModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        parent: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details_nutrition, parent, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val product = model.getSelected().value as Product

        val fatLevel: NutrientLevel = when {
            product.nutritionFacts.fat.quantityPerHundredGram >= 20 -> NutrientLevel.HIGH
            product.nutritionFacts.fat.quantityPerHundredGram >= 3 -> NutrientLevel.MODERATED
            else -> NutrientLevel.LOW
        }
        DrawableCompat.setTintList(
            fat_nutrient_level.background,
            ColorStateList.valueOf(requireContext().getColor(fatLevel.colorId))
        )
        fat_level.text = getString(fatLevel.stringId)
        fat_amount.text = getString(
            R.string.amount_of_fat,
            product.nutritionFacts.fat.quantityPerHundredGram,
            product.nutritionFacts.fat.unit
        )

        val saturatedFatLevel: NutrientLevel = when {
            product.nutritionFacts.saturatedFatAcid.quantityPerHundredGram >= 5 -> NutrientLevel.HIGH
            product.nutritionFacts.saturatedFatAcid.quantityPerHundredGram >= 1.5 -> NutrientLevel.MODERATED
            else -> NutrientLevel.LOW
        }
        DrawableCompat.setTintList(
            saturated_fat_nutrient_level.background,
            ColorStateList.valueOf(requireContext().getColor(saturatedFatLevel.colorId))
        )
        saturated_fat_level.text = getString(saturatedFatLevel.stringId)
        saturated_fat_amount.text = getString(
            R.string.amount_of_saturated_fat,
            product.nutritionFacts.saturatedFatAcid.quantityPerHundredGram,
            product.nutritionFacts.saturatedFatAcid.unit
        )

        val sugarLevel: NutrientLevel = when {
            product.nutritionFacts.sugar.quantityPerHundredGram >= 12.5 -> NutrientLevel.HIGH
            product.nutritionFacts.sugar.quantityPerHundredGram >= 5 -> NutrientLevel.MODERATED
            else -> NutrientLevel.LOW
        }
        DrawableCompat.setTintList(
            sugar_nutrient_level.background,
            ColorStateList.valueOf(requireContext().getColor(sugarLevel.colorId))
        )
        sugar_level.text = getString(sugarLevel.stringId)
        sugar_amount.text = getString(
            R.string.amount_of_sugar,
            product.nutritionFacts.sugar.quantityPerHundredGram,
            product.nutritionFacts.sugar.unit
        )

        val saltLevel: NutrientLevel = when {
            product.nutritionFacts.salt.quantityPerHundredGram >= 1.5 -> NutrientLevel.HIGH
            product.nutritionFacts.salt.quantityPerHundredGram >= 0.3 -> NutrientLevel.MODERATED
            else -> NutrientLevel.LOW
        }
        DrawableCompat.setTintList(
            salt_nutrient_level.background,
            ColorStateList.valueOf(requireContext().getColor(saltLevel.colorId))
        )
        salt_level.text = getString(saltLevel.stringId)
        salt_amount.text = getString(
            R.string.amount_of_salt,
            product.nutritionFacts.salt.quantityPerHundredGram,
            product.nutritionFacts.salt.unit
        )
    }

}