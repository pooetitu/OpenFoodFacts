package com.openfoodfacts.models


class NutritionFacts(
    val energy: NutritionFactsItem,
    val fat: NutritionFactsItem,
    val saturatedFatAcid: NutritionFactsItem,
    val carbohydrate: NutritionFactsItem,
    val sugar: NutritionFactsItem,
    val fibers: NutritionFactsItem,
    val proteins: NutritionFactsItem,
    val salt: NutritionFactsItem,
    val sodium: NutritionFactsItem,
)