package br.com.fiap.stockhive.functions

import android.util.Log
import androidx.navigation.NavController
import br.com.fiap.stockhive.model.Item
import br.com.fiap.stockhive.model.User
import br.com.fiap.stockhive.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun deleteItem(itemId: String, token: String, navController: NavController, username: String){

    val deleteItemCall = RetrofitFactory().getItemService().deleteItem(
        id = itemId,
        token = token
    )

    deleteItemCall.enqueue(object : Callback<String>{
        override fun onResponse(call: Call<String>, response: Response<String>) {
            Log.v("EDYLA", "${response.code()}")
            Log.v("EDYLA", response.toString())
            Log.v("EDYLA", response.body()!!)

            navController.navigate(
                "list/${token}/${username}"
            )

        }

        override fun onFailure(call: Call<String>, t: Throwable) {
            Log.v("EDYLA", t.toString())
        }

    })

}