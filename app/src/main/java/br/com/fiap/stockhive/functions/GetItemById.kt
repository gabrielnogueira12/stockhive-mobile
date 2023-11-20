package br.com.fiap.stockhive.functions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import br.com.fiap.stockhive.model.Item
import br.com.fiap.stockhive.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun getItemById(itemId: Int, token: String): Item {

    var item by remember {
        mutableStateOf(Item())
    }

    val getItemCall = RetrofitFactory().getItemService().getItemById(
        id = itemId,
        token = token
    )

    getItemCall.enqueue(object : Callback<Item>{
        override fun onResponse(call: Call<Item>, response: Response<Item>) {
            item = response.body()!!
        }

        override fun onFailure(call: Call<Item>, t: Throwable){

        }

    })

    return item
}