package br.com.fiap.stockhive.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.stockhive.R
import br.com.fiap.stockhive.ui.theme.Poppin

@Composable
fun CreateItemScreen() {

    var nomeItem by remember {
        mutableStateOf("")
    }

    var qntdItem by remember {
        mutableStateOf(0)
    }

    var vlrItem by remember {
        mutableStateOf(0.0)
    }

    var expanded by remember {
        mutableStateOf(false)
    }

    var selectedItem by remember {
        mutableStateOf("Item 1")
    }

    Box(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize()
    ){
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
        ){
            Column(
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
                        .padding(top = 10.dp)
                )
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 15.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(
                        painter = painterResource(R.drawable.arrow_down_24),
                        contentDescription = "Seta para baixo",
                        modifier = Modifier
                            .size(50.dp)
                            .padding(bottom = 5.dp)
                    )
                    Text(
                        text = "Cadastre um novo item",
                        fontFamily = Poppin,
                        fontSize = 21.sp
                    )
                }
                Column {
                    Text(
                        text = "Nome",
                        fontFamily = Poppin,
                        fontSize = 14.sp,
                        modifier = Modifier
                            .padding(start = 10.dp)
                    )
                    OutlinedTextField(
                        value = nomeItem,
                        onValueChange = {
                            nomeItem = it
                        },
                        placeholder = {
                            Text(
                                text = "Digite o nome do item",
                                fontFamily = Poppin
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier
                                .weight(1f)
                        ) {
                            Text(
                                text = "Quantidade de itens",
                                fontFamily = Poppin,
                                fontSize = 14.sp,
                                modifier = Modifier
                                    .padding(start = 10.dp)
                            )

                            OutlinedTextField(
                                value = "$qntdItem",
                                onValueChange = {
                                    qntdItem = it.toInt()
                                },
                                placeholder = {
                                    Text(
                                        text = "Digite a quantidade de itens",
                                        fontFamily = Poppin
                                    )
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 10.dp)
                            )
                        }

                        Column(
                            modifier = Modifier
                                .weight(1f)
                        ) {
                            Text(
                                text = "Valor unitário do item",
                                fontFamily = Poppin,
                                fontSize = 14.sp,
                                modifier = Modifier
                                    .padding(start = 10.dp)
                            )

                            OutlinedTextField(
                                value = "R$$vlrItem",
                                onValueChange = {
                                    vlrItem = it.toDouble()
                                },
                                placeholder = {
                                    Text(
                                        text = "Digite o valor unitário do item",
                                        fontFamily = Poppin
                                    )
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 10.dp)
                            )
                        }

                    }
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Selecione o tipo",
                        fontFamily = Poppin,
                        fontSize = 14.sp,
                        modifier = Modifier
                            .padding(start = 10.dp)
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { expanded = true }
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp)
                                .border(BorderStroke(
                                    width = 1.dp,
                                    color = Color.Black
                                )),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text=selectedItem,
                                modifier = Modifier.padding(5.dp)
                            )
                            Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null)
                        }
                    }
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false },
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        listOf("Item 1", "Item 2", "Item 3").forEach { item ->
                            DropdownMenuItem(
                                onClick = {
                                    selectedItem = item
                                    expanded = false
                                },
                                text = {
                                    Text(text = item)
                                }
                            )
                        }
                    }
//                OutlinedTextField(
//                    value = tipoItem,
//                    onValueChange = {
//                        tipoItem = it
//                    },
//                    placeholder = {
//                        Text(
//                            text = "Digite o tipo do item",
//                            fontFamily = Poppin
//                        )
//                    },
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(horizontal = 10.dp)
//                )

                    Spacer(modifier = Modifier.height(60.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ){
                        Button(
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(
                                0xFF313131
                            )
                            ),
                            modifier = Modifier
                                .width(180.dp)
                                .height(50.dp)
                        ) {
                            Text(
                                text = "Cadastrar Item",
                                fontFamily = Poppin,
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center
                            )
                        }

                    }
                }
        }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .padding(top=10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .clickable { }
                ) {
                    Column(
                        modifier = Modifier
                            .padding(horizontal = 10.dp),
                        verticalArrangement = Arrangement.Bottom,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = null,
                            modifier = Modifier
                                .size(30.dp)
                        )
                        Text(
                            text = "Início",
                            textAlign = TextAlign.Center,
                            fontFamily = Poppin,
                            fontSize = 11.sp,
                            modifier = Modifier
                                .padding(5.dp)
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .clickable { }
                ) {
                    Column(
                        modifier = Modifier
                            .padding(horizontal = 10.dp),
                        verticalArrangement = Arrangement.Bottom,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Icons.Default.List,
                            contentDescription = null,
                            modifier = Modifier
                                .size(30.dp)
                        )
                        Text(
                            text = "Listar",
                            textAlign = TextAlign.Center,
                            fontFamily = Poppin,
                            fontSize = 11.sp,
                            modifier = Modifier
                                .padding(5.dp)
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .clickable { }
                ) {
                    Column(
                        modifier = Modifier
                            .padding(horizontal = 10.dp),
                        verticalArrangement = Arrangement.Bottom,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = null,
                            modifier = Modifier
                                .size(30.dp)
                        )
                        Text(
                            text = "Adicionar",
                            textAlign = TextAlign.Center,
                            fontFamily = Poppin,
                            fontSize = 11.sp,
                            modifier = Modifier
                                .padding(5.dp)
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .clickable { }
                ) {
                    Column(
                        modifier = Modifier
                            .padding(horizontal = 10.dp),
                        verticalArrangement = Arrangement.Bottom,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Icons.Default.ExitToApp,
                            contentDescription = null,
                            modifier = Modifier
                                .size(30.dp)
                        )
                        Text(
                            text = "Sair",
                            textAlign = TextAlign.Center,
                            fontFamily = Poppin,
                            fontSize = 11.sp,
                            modifier = Modifier
                                .padding(5.dp)
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CreateItemScreenPreview() {
    CreateItemScreen()
}