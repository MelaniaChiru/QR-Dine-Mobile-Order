package com.example.mobile_dev_assign_1

import android.R.id.bold
import android.annotation.SuppressLint
import androidx.compose.ui.text.font.FontStyle
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
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
            .background(Color(0xFFF7FBFE))
            .padding(35.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(25.dp)

    ){
        Header(modifier = modifier)
        MenuItemsList(modifier = modifier)
        CheckoutSection(total = 100.00, modifier = modifier)
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
    val items = getMenuItems()
    Column (
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items.forEach { item ->
            MenuItem(
                name = item.name,
                price = item.price,
                description = item.description,
                imageSrc = item.image
            )
        }
    }
}

@Composable
fun getMenuItems(): List<MenuItemClass> {
    val names = stringArrayResource(R.array.menu_names)
    val descriptions = stringArrayResource(R.array.menu_descriptions)
    val prices = stringArrayResource(R.array.menu_prices)
    val images = stringArrayResource(R.array.menu_images)

    val menuItems =  mutableListOf<MenuItemClass>()
    for (i in 0 until names.size){
        /*
        * I wanted to save the images for the items in a String array along with the other info
        * We didn't learn how to transform a string into a drawable, so I did some external research
        * I used these sources:
        * https://stackoverflow.com/questions/21856260/how-can-i-convert-string-to-drawable
        * https://stackoverflow.com/questions/70062705/how-can-i-get-drawable-resource-by-string
        * */

        /**
         * looks up resource dynamically with 'getIdentifier(name, defType, packageName)'
         * I understand that this method is discouraged, but it's the solution I found to store all
         * the information I need for a menu item in order to be able to add menu items without
         * changing the code
         */

        val img = LocalContext.current.resources.getIdentifier(
            images[i],
            "drawable",
            LocalContext.current.packageName
        )

        val item = MenuItemClass(names[i], descriptions[i], prices[i].toDouble(), img)

        menuItems.add(item)
    }

    return menuItems

}

data class MenuItemClass (
    val name: String,
    val description: String,
    val price: Double,
    val image: Int,
    var quantity: Int = 0
)

@Composable
fun MenuItem(
    name: String,
    price: Double,
    description: String,
    imageSrc: Int
){
    var quantity by remember { mutableIntStateOf(0) }
    Row (
        Modifier
            .background(color = Color(0xFFC8E3F9), shape = RoundedCornerShape(8.dp))
            .fillMaxWidth()
            .border(
                BorderStroke(1.dp, Color(0xFF403B34)),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically

    )
    {
        MenuItemInfo(name, price, description, quantity) {newQuantity: Int -> quantity = newQuantity}
        Image(
            painter = painterResource(id = imageSrc),
            contentDescription = null,
            Modifier.width(90.dp)
        )
    }
}

@Composable
fun MenuItemInfo(
    name: String,
    price: Double,
    description: String,
    quantity: Int,
    onQuantityChange: (Int) -> Unit
) {
    Column (
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        val formattedPrice = "%.2f".format(price)
        Text(text = "$name - $formattedPrice$")
        Text(
            text = description,
            color = Color(0xFF6A8ED1),
            fontStyle = FontStyle.Italic,
            fontSize = 14.sp,
            modifier = Modifier
                .width(225.dp),
            lineHeight = 1.5.em
            )

        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = { if (quantity > 0) onQuantityChange(quantity - 1) },
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
            ) {
                Text(text = "—", fontSize = 16.sp, textAlign = TextAlign.Center)
            }

            Text(text = "$quantity", fontSize = 16.sp, textAlign = TextAlign.Center)

            Button(
                onClick = { if (quantity < 50) onQuantityChange(quantity + 1) },
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
            ) {
                Text(text = "+", fontSize = 16.sp, textAlign = TextAlign.Center)
            }
        }
    }

}

@Composable
fun CheckoutSection(total: Double, modifier: Modifier = Modifier){
    val gst = total * 0.05;
    val qst = total * 0.09975;
    val totalWithTax = total + gst + qst

    Column (
        verticalArrangement = Arrangement.spacedBy(25.dp),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column {
            Text(text = "Total: $" + "%.2f".format(total), fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text("GST(5%): $" + "%.2f".format(gst))
            Text("QST(9.975%): $" + "%.2f".format(qst))
            Text("Total (Tax Included): $" + "%.2f".format(totalWithTax), fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }

        Button(
            onClick = {placeOrder() },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Place Order",textAlign = TextAlign.Center)
        }
    }

}

fun placeOrder(){

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    Mobiledevassign1Theme {
        MenuApp()
    }
}

/*
* Menu item images attributions
* Bouillabaisse: https://www.vecteezy.com/vector-art/56659289-a-tropical-shrimp-delight(Ai Graphic from Vecteezy)
* Boeuf Bourguignon: https://www.vecteezy.com/vector-art/50049543-delicious-beef-bourguignon-stew-with-wine-carrots-and-onion-garnished-with-parsley-creative-banner (Maksym Boiko from Vecteezy)
* Coq au Vin: https://www.vecteezy.com/vector-art/17406545-yeyuk-bokeum-korean-food (Luz Eugenia Velasquez from Vecteezy)
* Ratatouille: https://www.vecteezy.com/vector-art/47299077-ratatouille-illustration-design (Fitri Handayani from Vecteezy)
* Cassoulet: https://www.vecteezy.com/vector-art/51581418-a-bowl-of-curry-with-vegetables-and-herbs-on-a-plate (H M Shamim Al Razi From Vecteezy)
* Crème Brûlée: https://www.vecteezy.com/vector-art/69742509-caramel-flan-a-delightful-dessert-experience (Nihal Khan from Vecteezy)
*/