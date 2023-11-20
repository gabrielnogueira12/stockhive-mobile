package br.com.fiap.stockhive.model

class User(
    private var username: String = "",
    private var password: String = "",
    private var token: String = ""
) {

    fun getUsername(): String {
        return username
    }

    fun setUsername(newUsername: String) {
        username = newUsername
    }

    fun getPassword(): String {
        return password
    }

    fun setPassword(newPassword: String) {
        password = newPassword
    }

    fun getToken(): String {
        return token
    }

    fun setToken(newToken: String) {
        token = newToken
    }
}