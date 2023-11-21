package br.com.fiap.stockhive.model

class User(
    private var nome: String = "",
    private var senha: String = ""
) {

    fun getUsername(): String {
        return nome
    }

    fun setUsername(newUsername: String) {
        nome = newUsername
    }

    fun getPassword(): String {
        return senha
    }

    fun setPassword(newPassword: String) {
        senha = newPassword
    }
}