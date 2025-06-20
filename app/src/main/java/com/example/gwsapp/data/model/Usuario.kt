package com.example.gwsapp.data.model

import com.google.gson.annotations.SerializedName

data class Usuario(
    @SerializedName("_id")
    val id: String? = null,
    val nome: String,
    val email: String,
    val dataNascimento: String,
    val senha: String
)

data class UsuarioCreateRequest(
    val nome: String,
    val email: String,
    val dataNascimento: String,
    val senha: String
)