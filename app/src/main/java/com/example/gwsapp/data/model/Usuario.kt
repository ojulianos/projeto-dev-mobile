package com.example.gwsapp.data.model

import com.google.gson.annotations.SerializedName

data class Usuario(
    val id: Int,
    val nome: String,
    val email: String,
    val dataNascimento: String,
    val senha: String
)
