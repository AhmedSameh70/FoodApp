package com.example.foodapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.foodapp.screens.dashboard.MainScreen
import com.example.foodapp.screens.detailFood.DetailScreen
import com.example.foodapp.screens.itemsList.ItemListScreen
import com.example.foodapp.ui.navigation.Screen
import com.example.foodapp.viewModel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppNavHost()
        }
    }
}

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    val vm: MainViewModel = viewModel()

    NavHost(navController = navController, startDestination = Screen.Home.route) {

        composable(route = Screen.Home.route) {
            MainScreen(
                viewModel = vm,
                onOpenItems = {id, title ->
                    navController.navigate(Screen.Items.path(id,title))

                },
                onOpenDetail = { food ->
                    vm.selectedFood(food)
                    navController.navigate(Screen.Detail.route)

                }
            )
        }

        composable(route = Screen.Items.route,
            arguments = listOf(
                navArgument("id"){type = NavType.StringType},
                navArgument("title"){type = NavType.StringType},
            )
            ){backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?:""
            val title = backStackEntry.arguments?.getString("title")?:""

            ItemListScreen(
                viewmodel = vm,
                id = id,
                title = title,
                onBackClick = {navController.navigateUp()},
                onOpenDetail = {foodModel ->
                    vm.selectedFood(foodModel)
                    navController.navigate(Screen.Detail.route)

                }
            )
        }

        composable( route = Screen.Detail.route) {
            val food by vm.selectedFood.collectAsState()
            if(food==null) {
                return@composable
            }

            DetailScreen(
                item = food!!,
                onBackClick = {navController.navigateUp()},
                onAddToCartClick = {},
                viewModel = vm,
                onOpenDetail = { next ->
                    vm.selectedFood(next)
                    navController.navigate(Screen.Detail.route){
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}

