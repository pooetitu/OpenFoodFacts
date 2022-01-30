package com.openfoodfacts

import com.openfoodfacts.models.Nutriscore
import com.openfoodfacts.models.NutritionFacts
import java.io.Serializable

class Product(
    val name: String,
    val brand: String,
    val barCode: String,
    val nutriscore: Nutriscore,
    val urlImage: String,
    val quantity: String,
    val soldInCountries: List<String>,
    val ingredients: List<String>,
    val allergens: List<String>,
    val additives: List<String>,
    val nutritionFacts: NutritionFacts
) : Serializable

