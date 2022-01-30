package com.openfoodfacts.models

import com.openfoodfacts.R


enum class NutrientLevel(val colorId: Int, val stringId: Int) {
    HIGH(
        R.color.nutrient_level_high,
        R.string.high_nutrient_level
    ),
    MODERATED(
        R.color.nutrient_level_moderate,
        R.string.moderate_nutrient_level
    ),
    LOW(
        R.color.nutrient_level_low,
        R.string.low_nutrient_level
    )
}