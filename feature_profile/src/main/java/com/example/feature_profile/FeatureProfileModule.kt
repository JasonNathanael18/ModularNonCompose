package com.example.feature_profile

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import com.example.router.FeatureScreenProfileRouteContract

@Module
@InstallIn(SingletonComponent::class)
class FeatureProfileModule {

    @Singleton
    @Provides
    fun providesFeatureProfileRouteContract(): FeatureScreenProfileRouteContract =
        FeatureProfileRouteContractImpl()
}