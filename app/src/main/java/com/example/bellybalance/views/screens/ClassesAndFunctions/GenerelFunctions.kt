package com.example.bellybalance.views.screens.ClassesAndFunctions

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// General function for the Green top-section of the Screens (with a Home and a Setting button)
@Composable
fun TopSection(context: Context) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(Color(0xFFE2F8DA))
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Tilbagepil
            Button(
                onClick = {
                    val intent = Intent(context, MainpageActivity::class.java)
                    context.startActivity(intent)
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8DA078)),
                shape = CircleShape,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home",
                    tint = Color.White,
                    modifier = Modifier.size(25.dp)
                )
            }
            // Tandhjul
            Button(
                onClick = {
                    val intent = Intent(context, SettingsActivity::class.java)
                    context.startActivity(intent)
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8DA078)),
                shape = CircleShape,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Settings",
                    tint = Color.White,
                    modifier = Modifier.size(25.dp)
                )
            }
        }
    }
}

// General function for the Green top-section of the Screens (without buttons)
@Composable
fun TopSectionWithoutButtons(context: Context) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(Color(0xFFE2F8DA))
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
        }
    }
}

// General function for header-text of the Screens
@Composable
fun HeaderText(
    headerText: String,
    modifier: Modifier = Modifier.fillMaxWidth().padding(top = 15.dp),
    textStyle: TextStyle = TextStyle(
        fontSize = 35.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        color = Color.Black
    )
) {
    Text(
        text = headerText,
        style = textStyle,
        modifier = modifier
    )
}

// General function for body-text of the Screens
@Composable
fun BodyText(
    bodyText: String,
    modifier: Modifier = Modifier.padding(horizontal = 15.dp),
    textStyle: TextStyle = TextStyle(
        fontSize = 20.sp,
        textAlign = TextAlign.Center,
        color = Color.Black
    )
) {
    Text(
        text = bodyText,
        style = textStyle,
        modifier = modifier
    )
}

// General function for the green bottom button of the Screens
@Composable
fun ButtonBottomSection(
    buttonLabel: String,
    onClick: () -> Unit,
    buttonColor: Color = Color(0xFF8DA078),
    textColor: Color = Color.White,
    borderColor: Color = Color.Transparent
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
        modifier = Modifier
            .padding(horizontal = 15.dp)
            .fillMaxWidth()
            .height(80.dp)
            .padding(bottom = 10.dp)
            .border(width = 2.dp, color = borderColor, shape = RoundedCornerShape(22.dp))
    ) {
        Text(
            text = buttonLabel,
            color = textColor,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
    }
}


// General function for an ads-section of the Screens
@Composable
fun AdsBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(Color.Blue),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Advertisements",
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}

// General function for a Time-input-field
@Composable
fun TimeInputSection() {
    var textFieldState by remember { mutableStateOf(TextFieldValue("")) }

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        TextField(
            value = textFieldState,
            onValueChange = { textFieldState = it },
            placeholder = { Text(text = "HH:MM") },
            modifier = Modifier
                .height(50.dp)
                .width(90.dp),
            shape = RoundedCornerShape(8.dp),
            singleLine = true,
        )
    }
}