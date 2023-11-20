package br.com.fiap.stockhive

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.stockhive.functions.getItemById
import br.com.fiap.stockhive.model.Item
import br.com.fiap.stockhive.model.User
import br.com.fiap.stockhive.screens.CreateItemScreen
import br.com.fiap.stockhive.screens.EditItemScreen
import br.com.fiap.stockhive.screens.ListItemsScreen
import br.com.fiap.stockhive.screens.LoginScreen
import br.com.fiap.stockhive.ui.theme.StockHiveTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StockHiveTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    var item = Item()
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "login"
                    ){
                        composable(route = "login"){
                            LoginScreen(navController)
                        }
                        composable(route = "list/{token}"){backStackEntry ->
                            var token = backStackEntry.arguments?.getString("token")!!
                            ListItemsScreen(navController, token)
                        }
                        composable(route = "edit/{itemId}/{token}"){ backStackEntry ->
                            var itemId = backStackEntry.arguments?.getString("itemId")!!
                            var token = backStackEntry.arguments?.getString("token")!!
                            item = getItemById(
                                itemId = itemId.toInt(),
                                token = token
                            )

                            EditItemScreen(
                                navController,
                                token,
                                item
                            )
                        }
                        composable(route = "create/{token}"){ backStackEntry ->
                            var token = backStackEntry.arguments?.getString("token")!!
                            CreateItemScreen(navController, token)
                        }
                    }

                }
            }
        }
    }
}
