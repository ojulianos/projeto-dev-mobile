package com.example.gwsapp.data.repository

import com.example.gwsapp.data.model.Categoria
import com.example.gwsapp.data.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoriaRepository {
    private val api = RetrofitClient.apiCatService
    fun getCategoria(onResult: (List<Categoria>?) -> Unit){
        api.getCategoria().enqueue(object : Callback<List<Categoria>> {
            override fun onResponse(call: Call<List<Categoria>>, response: Response<List<Categoria>>) {
                onResult(response.body())
            }

            override fun onFailure(call: Call<List<Categoria>?>, t: Throwable) {
                onResult(null)
            }
        })
    }

    fun createCategoria(categoria: Categoria, onResult: (Categoria?) -> Unit) {
        api.createCategoria(categoria).enqueue(object : Callback<Categoria> {
            override fun onResponse(call: Call<Categoria>, response: Response<Categoria>) {
                onResult(response.body())
            }

            override fun onFailure(call: Call<Categoria>, t: Throwable) {
                onResult(null)
            }
        })
    }

    fun updateCategoria(id: String, categoria: Categoria, onResult: (Categoria?) -> Unit) {
        api.updateCategoria(id, categoria).enqueue(object : Callback<Categoria> {
            override fun onResponse(call: Call<Categoria>, response: Response<Categoria>) {
                onResult(response.body())
            }

            override fun onFailure(call: Call<Categoria>, t: Throwable) {
                onResult(null)
            }
        })
    }

    fun deleteCategoria(id: String, onResult: (Boolean) -> Unit) {
        api.deleteCategoria(id).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                onResult(response.isSuccessful)
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                onResult(false)
            }
        })
    }
}
