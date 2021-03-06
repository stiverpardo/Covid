package com.david.hackro.covid.di

import com.david.hackro.covid.presentation.viewmodel.CountryDetailViewModel
import com.david.hackro.covid.presentation.viewmodel.HomeViewModel
import com.david.hackro.stats.di.dataSourceModule
import com.david.hackro.stats.di.networkHandlerModule
import com.david.hackro.stats.di.networkModule
import com.david.hackro.stats.di.repositoryModule
import com.david.hackro.stats.di.useCaseModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

fun injectFeatures() = loadFeature

private val loadFeature by lazy {
    loadKoinModules(
        arrayListOf(
            viewModelModule,
            useCaseModule,
            repositoryModule,
            dataSourceModule,
            networkModule,
            networkHandlerModule
        )
    )
}

val viewModelModule: Module = module {
    viewModel {
        HomeViewModel(getSummaryInfoUseCase = get(), getDataByStatusUseCase = get())
    }

    viewModel {
        CountryDetailViewModel(getDataByStatusUseCase = get())
    }
}
