package br.com.fiap.stockhive.service

import br.com.fiap.stockhive.model.TokenResponse
import br.com.fiap.stockhive.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface LoginService {

    @POST("auth/login")
    fun login(
        @Header("Content-Type") contentType:String = "application/json",
        @Body user: User
    ): Call<TokenResponse>
}