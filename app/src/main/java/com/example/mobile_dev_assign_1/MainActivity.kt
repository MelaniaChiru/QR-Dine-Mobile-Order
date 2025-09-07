package com.example.mobile_dev_assign_1

import androidx.compose.ui.text.font.FontStyle
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
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
            .padding(35.dp)
    ){
        Header(modifier = modifier)
        MenuItemsList(modifier = modifier)
        CheckoutSection(modifier = modifier)
    }
}

@Composable
fun Header(modifier: Modifier = Modifier){
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = null,
                Modifier.width(110.dp)
            )

            Spacer(modifier = Modifier.width(100.dp))

            Column(
                modifier = modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Nº items: 0"
                )

                Spacer(
                    modifier = Modifier.height(15.dp)
                )

                Button(onClick = {OnClearCartClick() } ) {
                    Text(text = "Clear Cart")
                }
            }
        }
        Text(
            text = "Scroll down for checkout",
            color = Color(0xFF919191),
            fontStyle = FontStyle.Italic,
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Right

        )
    }
}

fun OnClearCartClick(){
//    TODO: Reset cart and total price
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