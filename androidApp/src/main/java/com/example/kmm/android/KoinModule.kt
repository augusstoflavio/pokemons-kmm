package com.example.kmm.android

import com.example.kmm.data.api.Network
import com.example.kmm.data.api.PokemonService
import com.example.kmm.data.api.PokemonServiceImpl
import com.example.kmm.data.dataSource.PokemonDataSource
import com.example.kmm.data.dataSource.PokemonDataSourceImpl
import com.example.kmm.data.repository.PokemonRepositoryImpl
import com.example.kmm.domain.repository.PokemonRepository
import com.example.kmm.domain.useCase.GetPokemons
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object KoinModule {

    fun get(): Module {
        return module {
            single {
                Network()
            }

            single<PokemonService> {
                PokemonServiceImpl(get())
            }

            single<PokemonDataSource> {
                PokemonDataSourceImpl(get())
            }

            single<PokemonRepository> {
                PokemonRepositoryImpl(get())
            }

            single {
                GetPokemons(get())
            }

            viewModel {
                MainViewModel(get())
            }
        }
    }
}