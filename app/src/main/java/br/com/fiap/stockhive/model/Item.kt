package br.com.fiap.stockhive.model

data class Item(
    val cod: Int = 0,
    val nome: String = "",
    val qntd: Int = 0,
    val tipo: String = "",
    val valorUnitario: Double = 0.0
)
