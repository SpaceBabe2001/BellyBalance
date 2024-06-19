package com.example.bellybalance.views

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable

// Function for the main screen for showing FoodScreen.
// The functions TopSections, ButtonBottomSection and AdsBar is imported from the "GeneralFunctions.kt" file.
@Composable
fun FoodScreen() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TopSection(context)
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            FoodMiddleSection()
        }
        ButtonBottomSection(
            buttonLabel = "Gem fødevarer",
            onClick = {
                val intent = Intent(context, MainpageActivity::class.java)
                context.startActivity(intent)
            }
        )
        AdsBar()
    }
}

// Functions for the middle section of the FoodScreen.
@Composable
fun FoodMiddleSection() {
    val foodList = remember { mutableStateListOf<String>() }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(horizontal = 15.dp)
        ) {
            HeaderText(headerText = "Tilføj fødevarer")
            Spacer(modifier = Modifier.height(20.dp))
            BodyText(bodyText = "Hvornår spiste du sidst?")
            Spacer(modifier = Modifier.height(20.dp))
            TimeInputSection()
            Spacer(modifier = Modifier.height(30.dp))
            BodyText(bodyText = "Hvilke fødevarer spiste du?")
            Spacer(modifier = Modifier.height(20.dp))
            AddFoodSection(foodList = foodList)
            Spacer(modifier = Modifier.height(30.dp))
            BodyText(bodyText = "Dine valgte fødevarer:")
            Spacer(modifier = Modifier.height(20.dp))
            SelectedFoodsList(foodList = foodList)
        }
    }
}
@Composable
fun AddFoodSection(foodList: MutableList<String>) {
    var textFieldState by remember { mutableStateOf(TextFieldValue()) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Søg",
            fontSize = 20.sp,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.width(70.dp)
        )

        TextField(
            value = textFieldState,
            onValueChange = { textFieldState = it },
            modifier = Modifier
                .weight(1f)
                .height(50.dp)
                .padding(start = 1.dp, end = 8.dp),
            shape = RoundedCornerShape(8.dp),
            singleLine = true,
        )

        IconButton(
            onClick = {
                if (textFieldState.text.isNotEmpty()) {
                    foodList.add(textFieldState.text)
                    textFieldState = TextFieldValue("")
                }
            }
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add",
                tint = Color.Black
            )
        }
    }
}
@Composable
fun SelectedFoodsList(foodList: MutableList<String>) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
        ) {
            items(foodList) { food ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp, horizontal = 8.dp),
                ) {
                    Text(
                        text = food,
                        fontSize = 20.sp,
                        color = Color.Black,
                        modifier = Modifier.weight(1f)
                    )
                    IconButton(
                        onClick = {
                            foodList.remove(food)
                        },
                        modifier = Modifier.padding(start = 8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Clear,
                            contentDescription = "Delete",
                            tint = Color.Black
                        )
                    }
                }
                Divider(color = Color.Black, thickness = 1.dp)
            }
        }
    }
}

// Function for displaying the FoodScreen composable in the Android Studio preview
@Preview
@Composable
fun FoodPreview() {
    FoodScreen()
}