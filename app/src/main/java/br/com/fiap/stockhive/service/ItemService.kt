package br.com.fiap.stockhive.service

import br.com.fiap.stockhive.model.Item
import br.com.fiap.stockhive.model.NewItem
import br.com.fiap.stockhive.model.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ItemService {

    @GET("item/list")
    fun getAllItems(
        @Header("Authorization") token: String
    ): Call<List<Item>>

    @GET("item/{id}")
    fun getItemById(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): Call<Item>

    @POST("create")
    fun createItem(
        @Header("Authorization") token: String,
        @Body item: NewItem
    ): Call<NewItem>

    @PUT("update")
    fun updateItem(
        @Header("Authorization") token: String,
        @Body item: Item
    ): Call<Item>

    @DELETE("delete/{id}")
    fun deleteItem(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): Call<Item>

}