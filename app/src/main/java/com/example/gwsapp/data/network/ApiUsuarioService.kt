package com.example.gwsapp.data.network

import com.example.gwsapp.data.model.Usuario
import com.example.gwsapp.data.model.UsuarioCreateRequest
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
    fun createUsuario(@Body usuario: UsuarioCreateRequest): Call<Usuario>

    @PUT("usuarios/{id}")
    fun updateUsuario(@Path("_id") id: String, @Body usuario: Usuario): Call<Usuario>

    @DELETE("usuarios/{id}")
    fun deleteUsuario(@Path("_id") id: String): Call<Void>


}
