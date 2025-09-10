# Mobile-Dev-Assign-1

## Description
A restaurant app where users add menu items to their cart; When they are ready to order, all they have to do is click a button, and their order is transformed into JSON format and displayed as a QR code for the server to scan.

## Design Choices

### Data Classes
* I use 2 data classes: MenuItem, OrderItem
* I initially only had MenuItem, but when I got to the point where I had to encode it to JSON format, MenuItem wasn't the best. OrderItem is a simplified version of MenuItem: it does not have an image property, and the quantity property is a regular Int, not a state variable
* Therefore, when I get to the part where I loop through the MenuItemsList, I map each MenuItem to an OrderItem.

### State Variables
* I have a total of 4 state variables: MenuItemsList, totalQty, subTotal, and qrCodeBitmap
* Making MenuItemsList a state variable is the most obvious of them all. I need to keep track of all the items' quantities to be able to update the total.
* totalQty is the value displayed at the top of the screen, where it just shows users how many items they have in their cart.
* subTotal is the total price before the taxes are calculated
  * While these 2 variables could have been computed from MenuItemList, It was easier and more intuitive for me to make them separate from the MenuItemsList, so they could be each passed down as parameters to the composables that needed them.
* qrCodeBitmap is also a state variable because it is updated everytime the 'place order' button is clicked. Since it only has to be displayed after the button click, it starts off with a value of null, and gets updated when the button is clicked using the generateQRCode() function and MenuItemsList.

* After I was done with a the needed requirements, I had some time before submission, so I added some extra features.
  * First of all, I hide the qrCode from view if a user clears their cart (because if their cart is empty, it's useless to show a qrCode of an empty array.
  * Secondly, if a user wants to place an order, but they haven't added any items to their cart, the qr code is not displayed and a warning message stating that their cart is empty appears.

Both these features use the state of the menuItemsList and the qrCodeBitmap

### Styling / Design
* My UI slightly differs from the once in the instructions.
  * I wanted to show the total number of items in a user's cart, so i added that at the top of the screen next to the logo.
  * Because of this feature, I found it more intuitive to have the 'clear cart' button underneath the number of items instead of at the bottom of the app next to the 'place order' button.
  * I've also added images, mostly because I wanted my app to be more visually appealing.
  
### Custom Composables
* **MenuApp**: The root of the project, the composable that calls on all other composables
* **Header**: Contains logo and displays total number of items in cart (and the 'clear cart' button)
* **MenuItemsList**: A column that contains each menu item
* **MenuItemContainer**: A row that contains the menu item info and the image
* **MenuItemInfo**:  Composable that displays the menu item name, price, description, and quantity (and buttons to change quantity
* **CheckoutSection**: Composable that shows subtotal, taxes, and total. 'Place order' button and qrCode are also displayed in this composable

### Composable functions vs. regular functions
* For the most part, my functions are composables
* In situations where the function does some sort of logical operation and does not display anything to the screen (or need to call a composable), then it's a regular function

### QR Code
* When the app is initially started, the QR code is not displayed, instead there is a message stating that the cart is empty.
* Once the user increments the quantity of an item, the message disappears, but they still have to click the 'place order' button for the QR code to show up.
* If a QR code is displayed, and the users clears their cart, the QR code disappears.
* If a users clicks on 'place order', but they have not added any items to their cart, the QR code is not displayed and the warning message appears.

## External Code and Images Attributions

### Images
* Menu item images attributions
  * Bouillabaisse: https://www.vecteezy.com/vector-art/56659289-a-tropical-shrimp-delight(Ai Graphic from Vecteezy)
  * Boeuf Bourguignon: https://www.vecteezy.com/vector-art/50049543-delicious-beef-bourguignon-stew-with-wine-carrots-and-onion-garnished-with-parsley-creative-banner (Maksym Boiko from Vecteezy)
  * Coq au Vin: https://www.vecteezy.com/vector-art/17406545-yeyuk-bokeum-korean-food (Luz Eugenia Velasquez from Vecteezy)
  * Ratatouille: https://www.vecteezy.com/vector-art/47299077-ratatouille-illustration-design (Fitri Handayani from Vecteezy)
  * Cassoulet: https://www.vecteezy.com/vector-art/51581418-a-bowl-of-curry-with-vegetables-and-herbs-on-a-plate (H M Shamim Al Razi From Vecteezy)
  * Crème Brûlée: https://www.vecteezy.com/vector-art/69742509-caramel-flan-a-delightful-dessert-experience (Nihal Khan from Vecteezy)
* I created the logo using Canva


### External Code
* Transform String Array image name to drawable:
  * https://stackoverflow.com/questions/21856260/how-can-i-convert-string-to-drawable
  * https://stackoverflow.com/questions/70062705/how-can-i-get-drawable-resource-by-string
  
* Transform Kotlin Object / Class to JSON: https://www.bezkoder.com/kotlin-parse-json-gson/#Convert_Object_to_JSON_string_in_Kotlin
* Encrypt JSON file to QR Code: https://gitlab.com/crdavis/texttoqrcode
