package com.example.feature_profile

import androidx.core.os.bundleOf
import androidx.navigation.NavController
import com.example.profile.R
import com.example.router.FeatureScreenProfileRouteContract
import com.example.router.FeatureScreenRepoListRouteContract

class FeatureProfileRouteContractImpl : FeatureScreenProfileRouteContract {
    override fun show(dataToPass: String, navController: NavController) {
        navController.navigate(R.id.nav_graph_profile, bundleOf("argProfileValue" to dataToPass))
    }
}