package com.example.kmm.android

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kmm.domain.entity.Pokemon
import com.example.kmm.domain.useCase.GetPokemons
import com.example.kmm.extensions.run

class MainViewModel(private val getPokemons: GetPokemons): ViewModel() {

    private val _pokemons: MutableLiveData<Resource<List<Pokemon>>> = MutableLiveData()
    val pokemons: LiveData<Resource<List<Pokemon>>> = _pokemons

    init {
        getPokemons()
    }

    private fun getPokemons() {
        run(_pokemons) {
            getPokemons.invoke()
        }
    }
}