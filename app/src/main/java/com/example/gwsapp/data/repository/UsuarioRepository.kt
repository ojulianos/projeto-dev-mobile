package com.example.gwsapp.data.repository

import com.example.gwsapp.data.model.Usuario
import com.example.gwsapp.data.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsuarioRepository {
    private val api = RetrofitClient.apiService
    fun getUsuarios(onResult: (List<Usuario>?) -> Unit) {
        api.getUsuarios().enqueue(object : Callback<List<Usuario>> {
            override fun onResponse(call: Call<List<Usuario>>, response: Response<List<Usuario>>) {
                onResult(response.body())
            }

            override fun onFailure(call: Call<List<Usuario>>, t: Throwable) {
                onResult(null)
            }
        })
    }

    fun createUsuario(usuario: Usuario, onResult: (Usuario?) -> Unit) {
        api.createUsuario(usuario).enqueue(object : Callback<Usuario> {
            override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                onResult(response.body())
            }

            override fun onFailure(call: Call<Usuario>, t: Throwable) {
                onResult(null)
            }
        })
    }

    fun updateUsuario(id: String, usuario: Usuario, onResult: (Usuario?) -> Unit) {
        api.updateUsuario(id, usuario).enqueue(object : Callback<Usuario> {
            override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                onResult(response.body())
            }

            override fun onFailure(call: Call<Usuario>, t: Throwable) {
                onResult(null)
            }
        })
    }

    fun deleteUsuario(id: String, onResult: (Boolean) -> Unit) {
        api.deleteUsuario(id).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                onResult(response.isSuccessful)
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                onResult(false)
            }
        })
    }
}