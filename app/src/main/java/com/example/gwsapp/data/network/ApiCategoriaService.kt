package com.example.gwsapp.data.network

import com.example.gwsapp.data.model.Categoria
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiCategoriaService {
    @GET("categoria")
    fun getCategoria(): Call<List<Categoria>>

    @POST("categoria")
    fun createCategoria(@Body categoria: Categoria): Call<Categoria>

    @PUT("categoria/{id}")
    fun updateCategoria(@Path("id") id: Int, @Body categoria: Categoria): Call<Categoria>

    @DELETE("categoria/{id}")
    fun deleteCategoria(@Path("id") id: Int): Call<Void>



}