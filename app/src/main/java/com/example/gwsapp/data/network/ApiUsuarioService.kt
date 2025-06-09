package com.example.gwsapp.data.network

import com.example.gwsapp.data.model.Usuario
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiUsuarioService {
    @GET("usuarios")
    fun getUsuarios(): Call<List<Usuario>>

    @POST("usuarios")
    fun createUsuario(@Body usuario: Usuario): Call<Usuario>

    @PUT("usuarios/{id}")
    fun updateUsuario(@Path("id") id: String, @Body usuario: Usuario): Call<Usuario>

    @DELETE("usuarios/{id}")
    fun deleteUsuario(@Path("id") id: String): Call<Void>


}
