package com.example.kmm.android.extensions

import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import com.example.kmm.android.ui.utils.Resource
import com.example.kmm.data.api.exception.NoConnectionException

fun <T> AppCompatActivity.observerResource(resource: LiveData<Resource<T>>, progress: View, callback: (T) -> Any) {
    resource.observe(this) {
        when(it) {
            is Resource.Loading -> {progress.visibility = View.VISIBLE}
            is Resource.Failure -> {
                if (it.error is NoConnectionException) {
                    Toast.makeText(this, "Verifique a sua conexão", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Ops, tivemos um problema, tente novamente mais tarde", Toast.LENGTH_SHORT).show()
                }
            }
            is Resource.Success -> {
                progress.visibility = View.INVISIBLE
                callback.invoke(it.data)
            }
        }

        if (it !is Resource.Loading) {
            progress.visibility = View.GONE
        }
    }
}