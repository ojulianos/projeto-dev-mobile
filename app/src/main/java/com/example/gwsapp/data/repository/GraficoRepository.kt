package com.example.gwsapp.data.repository

import android.content.Context
import com.example.gwsapp.data.model.DadoGrafico
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object GraficoRepository {
    fun carregarDadosJson(context: Context): List<DadoGrafico> {
        val jsonString = context.assets.open("dados.json").bufferedReader().use { it.readText() }
        val gson = Gson()
        val tipo = object : TypeToken<List<DadoGrafico>>() {}.type
        return gson.fromJson(jsonString, tipo)
    }
}