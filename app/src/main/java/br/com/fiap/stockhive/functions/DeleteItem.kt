package br.com.fiap.stockhive.functions

import br.com.fiap.stockhive.model.Item
import br.com.fiap.stockhive.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun deleteItem(itemId: String, token: String){

    val deleteItemCall = RetrofitFactory().getItemService().deleteItem(
        id = itemId,
        token = token
    )

    deleteItemCall.enqueue(object : Callback<Item>{
        override fun onResponse(call: Call<Item>, response: Response<Item>) {
            TODO("Not yet implemented")
        }

        override fun onFailure(call: Call<Item>, t: Throwable) {
            TODO("Not yet implemented")
        }

    })

}