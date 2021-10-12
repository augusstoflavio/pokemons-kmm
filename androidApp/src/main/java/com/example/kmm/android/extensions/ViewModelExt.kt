package com.example.kmm.android.extensions

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kmm.android.ui.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun <T> ViewModel.run(livedate: MutableLiveData<Resource<T>>, action: suspend () -> T) {
    viewModelScope.launch(Dispatchers.IO) {
        livedate.postValue(Resource.Loading)
        kotlin.runCatching {
            action.invoke()
        }.onSuccess {
            livedate.postValue(Resource.Success(it))
        }.onFailure {
            livedate.postValue(Resource.Failure(it))
        }
    }
}