package br.com.fiap.stockhive.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    private val URL = "http://localhost:3000"

    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getItemService(): ItemService {
        return retrofitFactory.create(ItemService::class.java)
    }

}