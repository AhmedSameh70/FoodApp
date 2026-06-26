package com.example.foodapp.ui.navigation

import com.example.foodapp.domaine.FoodModel
import kotlinx.coroutines.flow.MutableStateFlow

sealed class Screen(val route: String) {
    data object Home : Screen("home")

    data object Items : Screen("itemsList/{id}/{title}") {
        fun path(id: String, title: String) =
            "itemsList/$id/${
                java.net.URLEncoder
                    .encode(title, Charsets.UTF_8.name())
            }"
    }

data object Detail : Screen("detail")
}