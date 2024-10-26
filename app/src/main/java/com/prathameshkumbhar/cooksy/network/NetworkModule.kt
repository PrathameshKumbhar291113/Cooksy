package com.prathameshkumbhar.cooksy.network

import android.content.Context
import com.prathameshkumbhar.cooksy.service.NetworkMonitorService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideNetworkMonitor(@ApplicationContext context: Context): NetworkMonitorService {
        return NetworkMonitorService(context)
    }
}
