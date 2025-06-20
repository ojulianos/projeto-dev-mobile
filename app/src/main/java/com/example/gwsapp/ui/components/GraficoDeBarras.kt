package com.example.gwsapp.ui.components

import android.graphics.Color.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import android.graphics.Paint
import android.graphics.Paint.*
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.dp
import com.example.gwsapp.data.model.DadoGrafico
import kotlin.random.Random

@Composable
fun GraficoDeBarras(dados: List<DadoGrafico>) {
    val valorMax = dados.maxOf { it.valor }

    Column (
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
    ) {
        Text(text = "Qtd. Presenças X Mês")
        Divider(
            modifier = Modifier.padding(top=5.dp, bottom = 15.dp)
        )
        Canvas(modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(16.dp)) {

            val larguraBarra = size.width / (dados.size * 2)

            dados.forEachIndexed { index, dado ->
                val altura = (dado.valor / valorMax.toFloat()) * size.height
                val x = (index * 2 + 1) * larguraBarra

                drawRect(
                    color = corAleatoria(),
                    topLeft = Offset(x, size.height - altura),
                    size = Size(larguraBarra, altura)
                )

                drawContext.canvas.nativeCanvas.drawText(
                    dado.valor.toString(),
                    x + larguraBarra / 2,
                    (size.height - size.height) - 25,
                    dataPaint()
                )

                drawContext.canvas.nativeCanvas.drawText(
                    dado.categoria,
                    x + larguraBarra / 2,
                    size.height + 50,
                    dataPaint()
                )
            }
        }
    }
}

fun corAleatoria(): Color {
    return Color(
        red = Random.nextFloat(),
        green = Random.nextFloat(),
        blue = Random.nextFloat(),
        alpha = 1f
    )
}

fun dataPaint(): Paint {
    return Paint().apply {
        color = BLACK
        textAlign = Align.CENTER
        textSize = 30f
    }
}