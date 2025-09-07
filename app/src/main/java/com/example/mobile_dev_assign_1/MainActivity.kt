package com.example.mobile_dev_assign_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mobile_dev_assign_1.ui.theme.Mobiledevassign1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Mobiledevassign1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MenuApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MenuApp(modifier: Modifier = Modifier) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7FBFE))
    ){
        Header(modifier = modifier)
        MenuItemsList(modifier = modifier)
        CheckoutSection(modifier = modifier)
    }
}

@Composable
fun Header(modifier: Modifier = Modifier){
    Image(
        painter = painterResource(R.drawable.logo),
        contentDescription = null,
        Modifier.width(110.dp)
    )

    // Add text composable that shows how many items in cart
    // have a "clear cart" button that resets item count and price
}

@Composable
fun MenuItemsList(modifier: Modifier = Modifier){
//    A list of all the menu items
//    A column looping though the String Array of menu items

}

@Composable
fun MenuItem(
    title: String,
    price: Double,
    description: String,
    imageSrc: String
){
    // represents 1 single menu item
}

@Composable
fun CheckoutSection(modifier: Modifier = Modifier){
//    Display total and taxes
//    Have place order button
//    eventually show QR code when button is clicked

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    Mobiledevassign1Theme {
        MenuApp()
    }
}