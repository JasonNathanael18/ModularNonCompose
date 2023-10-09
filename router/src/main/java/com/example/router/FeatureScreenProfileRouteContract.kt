package com.example.router

import androidx.navigation.NavController

interface FeatureScreenProfileRouteContract {
    fun show(dataToPass: String, navController: NavController)
}