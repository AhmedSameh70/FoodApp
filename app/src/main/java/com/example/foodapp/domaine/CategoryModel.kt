package com.example.foodapp.domaine

import com.google.firebase.database.PropertyName

data class CategoryModel(
    @get:PropertyName("Id") @set:PropertyName("Id") var Id: Int = 0,
    @get:PropertyName("ImagePath") @set:PropertyName("ImagePath") var ImagePath: String = "",
    @get:PropertyName("Name") @set:PropertyName("Name") var Name: String = ""
) {
    constructor() : this(0, "", "")
}