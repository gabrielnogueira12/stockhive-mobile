package br.com.fiap.stockhive.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.stockhive.R
import br.com.fiap.stockhive.model.User
import br.com.fiap.stockhive.service.RetrofitFactory
import br.com.fiap.stockhive.ui.theme.Poppin
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@Composable
fun LoginScreen(navController: NavController) {

    var username by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "STOCK HIVE",
                    textAlign = TextAlign.Center,
                    fontFamily = Poppin,
                    fontSize = 40.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Card(
                    modifier = Modifier
                        .height(300.dp)
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .background(Color(0x80FCFCFC)),
                    colors = CardDefaults.cardColors(containerColor = Color(0x80FCFCFC)),
                    elevation = CardDefaults.cardElevation(1.dp)
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color(0x80FCFCFC))
                    ){
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color(0x80FCFCFC))
                        ) {
                            OutlinedTextField(
                                value = username,
                                onValueChange = {
                                    username = it
                                },
                                leadingIcon = {
                                    Icon(
                                        painter = painterResource(
                                            id = R.drawable.person_24
                                        ),
                                        contentDescription = "Ícone de pessoa")
                                },
                                label = {
                                    Text(
                                        text = "Usuário",
                                        fontFamily = Poppin
                                    )
                                },
                                placeholder = {
                                    Text(
                                        text = "Digite seu usuário",
                                        fontFamily = Poppin
                                    )
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 15.dp)
                            )
                            OutlinedTextField(
                                value = password,
                                onValueChange = {
                                    password = it
                                },
                                leadingIcon = {
                                    Icon(
                                        imageVector = Icons.Default.Create,
                                        contentDescription = "Ícone de lápis")
                                },
                                label = {
                                    Text(
                                        text = "Senha",
                                        fontFamily = Poppin
                                    )
                                },
                                placeholder = {
                                    Text(
                                        text = "Digite sua senha",
                                        fontFamily = Poppin
                                    )
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 15.dp)
                            )
                            Spacer(modifier = Modifier.height(40.dp))
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Color(0x80FCFCFC))
                            ){
                                Button(
                                    onClick = {
                                        val loginUser = User(
                                            username = username,
                                            password = password
                                        )
                                        val call = RetrofitFactory().getLoginService().login(
                                            user = loginUser
                                        )

                                        Log.v("EDYLA", "Chegou no call")
                                        Log.v("EDYLA", "username: ${loginUser.getUsername()}")
                                        Log.v("EDYLA", "pass: ${loginUser.getPassword()}")

//                                        call.enqueue(object : Callback<JSONObject>{
//                                            override fun onResponse(
//                                                call: Call<JSONObject>,
//                                                response: Response<JSONObject>
//                                            ) {
//                                                Log.v("EDYLA", "Login deu bom")
//                                                val jsonObj = JSONObject(response.body().toString())
//                                                loginUser.setToken(jsonObj.getString("token"))
//                                            }
//
//                                            override fun onFailure(call: Call<JSONObject>, t: Throwable) {
//                                                val msg = t.message!!
//                                                Log.v("EDYLA", "Deu erro no login")
//                                                //navController.navigate("login")
//                                            }
//
//                                        })
                                        navController.navigate("list/eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0ZSIsImlhdCI6MTcwMDUxNDkxOSwiZXhwIjoxNzAwNTE1NjE5fQ.lzPmYy9L-IIE4t_Oy5XWxFohnlwnKt21yJXz2UkRaW_8dBHDKrNcJU-kF1wPNksN9TGiSxrsxPIkSJmD7guVbA")
                                        // navController.navigate("list/${loginUser.getToken()}")

                                    },
                                    colors = ButtonDefaults.buttonColors(containerColor = Color(
                                        0xFF313131
                                    )
                                    ),
                                    modifier = Modifier
                                        .width(150.dp)
                                        .height(50.dp)
                                ) {
                                    Text(
                                        text = "Entrar",
                                        fontFamily = Poppin,
                                        fontSize = 21.sp
                                    )
                                }
                            }
                        }
                    }
                }
            }
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Column (
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.underimage),
                        contentDescription = "Imagem de rodapé",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 20.dp, horizontal = 20.dp)
                    )
                    Text(
                        text = "O mundo não para. \nNós também não.",
                        textAlign = TextAlign.Center,
                        fontFamily = Poppin,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
}