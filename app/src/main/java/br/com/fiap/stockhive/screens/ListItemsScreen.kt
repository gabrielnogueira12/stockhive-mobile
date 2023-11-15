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
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.stockhive.ui.theme.Poppin

@Composable
fun ListItemsScreen(navController: NavController) {

    val nomeItem by remember {
        mutableStateOf("Nome do Item")
    }

    val qntdItem by remember {
        mutableStateOf(0)
    }

    val vlrItem by remember {
        mutableStateOf(0.0)
    }

    val tipoItem by remember {
        mutableStateOf("Tipo do Item")
    }


    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "STOCK HIVE",
                    textAlign = TextAlign.Center,
                    fontFamily = Poppin,
                    fontSize = 40.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp)
                )
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.LightGray),
                    elevation = CardDefaults.cardElevation(3.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                Text(
                                    text = "Item:",
                                    fontFamily = Poppin,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    modifier = Modifier.padding(start = 10.dp, top = 10.dp)
                                )
                                Text(
                                    text = nomeItem,
                                    fontFamily = Poppin,
                                    fontSize = 18.sp,
                                    modifier = Modifier.padding(start = 10.dp)
                                )
                            }
                            Spacer(modifier = Modifier.height(5.dp))
                            Row(
                                horizontalArrangement = Arrangement.Start,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Column {
                                    Text(
                                        text = "Quantidade:",
                                        fontFamily = Poppin,
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        modifier = Modifier.padding(start = 10.dp)
                                    )
                                    Text(
                                        text = "$qntdItem",
                                        fontFamily = Poppin,
                                        fontSize = 18.sp,
                                        modifier = Modifier.padding(start = 10.dp)
                                    )
                                }
                                Spacer(modifier = Modifier.width(10.dp))
                                Column {
                                    Text(
                                        text = "Valor Unitário:",
                                        fontFamily = Poppin,
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        modifier = Modifier.padding(start = 10.dp)
                                    )
                                    Text(
                                        text = "R$$vlrItem",
                                        fontFamily = Poppin,
                                        fontSize = 18.sp,
                                        modifier = Modifier.padding(start = 10.dp)
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.height(5.dp))
                            Row (
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ){
                                Text(
                                    text = "Tipo:",
                                    fontFamily = Poppin,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    modifier = Modifier.padding(start = 10.dp)
                                )
                                Text(
                                    text = tipoItem,
                                    fontFamily = Poppin,
                                    fontSize = 18.sp,
                                    modifier = Modifier.padding(start = 10.dp)
                                )
                            }
                            Row(
                                horizontalArrangement = Arrangement.End,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .clickable { }
                                        .border(
                                            BorderStroke(
                                                width = 1.dp,
                                                color = Color.DarkGray
                                            ),
                                            shape = RoundedCornerShape(5.dp)
                                        )
                                        .padding(3.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Edit,
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(30.dp)
                                    )
                                }
                                Spacer(modifier=Modifier.width(10.dp))
                                Box(
                                    modifier = Modifier
                                        .clickable { }
                                        .border(
                                            BorderStroke(
                                                width = 1.dp,
                                                color = Color.Red
                                            ),
                                            shape = RoundedCornerShape(5.dp)
                                        )
                                        .padding(3.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Clear,
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(30.dp),
                                        tint = Color.Red
                                    )
                                }
                            }
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
                        .clickable {
                            navController.navigate("list")
                        }
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
                        .clickable {
                            navController.navigate("create")
                        }
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
                        .clickable {
                            navController.navigate("login")
                        }
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
fun ListItemsScreenPreview() {
}