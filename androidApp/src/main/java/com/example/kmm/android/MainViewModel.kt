package com.example.kmm.android

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kmm.domain.entity.Pokemon
import com.example.kmm.domain.useCase.GetPokemons
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val getPokemons: GetPokemons): ViewModel() {


    private val _pokemons: MutableLiveData<Resource<List<Pokemon>>> = MutableLiveData()
    val pokemons: LiveData<Resource<List<Pokemon>>> = _pokemons

    init {
        getPokemons()
    }

    private fun getPokemons() {
        viewModelScope.launch(Dispatchers.IO) {
            _pokemons.postValue(Resource.Loading)
            kotlin.runCatching {
                getPokemons.invoke()
            }.onSuccess {
                _pokemons.postValue(Resource.Success(it))
            }.onFailure {
                _pokemons.postValue(Resource.Failure(it.message ?: ""))
            }
        }
    }
}