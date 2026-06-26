package com.example.foodapp.domaine

import com.google.firebase.database.PropertyName
import java.io.Serializable

data class FoodModel(
    @get:PropertyName("BestFood") @set:PropertyName("BestFood") var BestFood: Boolean = false,
    @get:PropertyName("CategoryId") @set:PropertyName("CategoryId") var CategoryId: String = "",
    @get:PropertyName("Description") @set:PropertyName("Description") var Description: String = "",
    @get:PropertyName("Id") @set:PropertyName("Id") var Id: Int = 0,
    @get:PropertyName("ImagePath") @set:PropertyName("ImagePath") var ImagePath: String = "",
    @get:PropertyName("LocationId") @set:PropertyName("LocationId") var LocationId: Int = 0,
    @get:PropertyName("Price") @set:PropertyName("Price") var Price: Double = 0.0,
    @get:PropertyName("PriceId") @set:PropertyName("PriceId") var PriceId: Int = 0,
    @get:PropertyName("Star") @set:PropertyName("Star") var Star: Double = 0.0,
    @get:PropertyName("TimeId") @set:PropertyName("TimeId") var TimeId: Int = 0,
    @get:PropertyName("TimeValue") @set:PropertyName("TimeValue") var TimeValue: Int = 0,
    @get:PropertyName("Title") @set:PropertyName("Title") var Title: String = "",
    @get:PropertyName("Calorie") @set:PropertyName("Calorie") var Calorie: Int = 0,
    @get:PropertyName("numberInCart") @set:PropertyName("numberInCart") var numberInCart: Int = 0
) : Serializable {
    constructor() : this(false, "", "", 0, "", 0, 0.0, 0, 0.0, 0, 0, "", 0, 0)
}
