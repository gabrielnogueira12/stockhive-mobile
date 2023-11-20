package br.com.fiap.stockhive.service

import br.com.fiap.stockhive.model.User
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {

    @POST("auth/login")
    fun login(
        @Body user: User
    ): Call<JSONObject>
}