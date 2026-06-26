package com.example.foodapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.foodapp.Repository.MainRepository
import com.example.foodapp.domaine.CategoryModel
import com.example.foodapp.domaine.FoodModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {
    private val repository = MainRepository()

    fun loadCategory(): LiveData<MutableList<CategoryModel>> {
        return repository.loadCategory()
    }

    fun loadBestFood(): LiveData<MutableList<FoodModel>>{
        return repository.loadBestFood()
    }

    fun loadFiltered(id: String): LiveData<MutableList<FoodModel>> {
        return repository.loadFiltered(id)
    }

    private val _selectedFood = MutableStateFlow<FoodModel?>(null)
    val selectedFood: StateFlow<FoodModel?> = _selectedFood
    fun selectedFood(foodModel: FoodModel?) {
        _selectedFood.value = foodModel
    }
}