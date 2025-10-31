# 🍽️ QR-Dine Mobile Order

A restaurant app where users add menu items to their cart; When they are ready to order, all they have to do is click a button, and their order is transformed into JSON format and displayed as a QR code for the server to scan.

## 🛠️ Tech Stack
* Kotlin
* Jetpack Compose

## 🎥 Video Preview


https://github.com/user-attachments/assets/5aceabb2-81d9-4911-82c1-bdfe47e0e731



## ⚙️ Setup instructions
_This is assuming Android Studio is being used_
1. Clone or Fork the Repository
2. Open the cloned folder in Android Studio
3. Wait for the Gradle to sync (may take a few minutes)
4. Configure SDK
   - The project was built with **Android SDK API 26**
   - Make sure you have API 26 (Android 8.0 – Oreo) installed in the SDK Manager.
   - Your emulator or device can use a newer version, but the minimum SDK should be API 26
5. Run the App
You can either:
  - Set up an emulator (minimum API 26) and run the MainActivity.kt project
  - Connect to a physical _Android_ device using wifi
  - Connect to a physical _Android_ device using a usb cable and developer more enabled

## <img width="30" height="30" alt="image-hheqtvAvZLesg9WYTVCosfDrtUtC7H" src="https://github.com/user-attachments/assets/2950cc78-669c-4102-a8b1-86eb1c82b46e" /> QR Code
* When the app is initially started, the QR code is not displayed, instead there is a message stating that the cart is empty.
* Once the user increments the quantity of an item, the message disappears, but they still have to click the 'place order' button for the QR code to show up.
* If a QR code is displayed, and the users clears their cart, the QR code disappears.
* If a users clicks on 'place order', but they have not added any items to their cart, the QR code is not displayed and the warning message appears.
* However if the user selects and item, presses 'place order', and then adds another item, the previous qr code will not be regenerated until 'place order' button is clicked again.

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
