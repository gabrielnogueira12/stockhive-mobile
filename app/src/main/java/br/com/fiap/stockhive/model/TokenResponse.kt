package br.com.fiap.stockhive.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TokenResponse(
    @SerializedName("accessToken")
    @Expose
    var accessToken: String,
    @SerializedName("tokenType")
    @Expose
    var tokenType: String
) {
}