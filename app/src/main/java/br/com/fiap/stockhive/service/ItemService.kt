package br.com.fiap.stockhive.service

import br.com.fiap.stockhive.model.Item
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface ItemService {

    @GET("item/list")
    fun getAllItems(): Call<List<Item>>

}