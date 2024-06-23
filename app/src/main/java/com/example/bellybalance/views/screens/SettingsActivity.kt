package com.example.bellybalance.views.screens

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.*
import com.example.bellybalance.views.screens.ClassesAndFunctions.AdsBar
import com.example.bellybalance.views.screens.ClassesAndFunctions.ButtonBottomSection
import com.example.bellybalance.views.screens.ClassesAndFunctions.HeaderText
import com.example.bellybalance.views.screens.ClassesAndFunctions.MainActivity
import com.example.bellybalance.views.screens.ClassesAndFunctions.MainpageActivity
import com.example.bellybalance.views.screens.ClassesAndFunctions.TopSection
import com.example.bellybalance.views.screens.ClassesAndFunctions.UpgradeLoggedinActivity

// Function for the main screen for showing SettingsScreen.
// The functions TopSections, ButtonBottomSection and AdsBar is imported from the "GenerelFunctions.kt" file.
@Composable
fun SettingsScreen() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TopSection(context)
        Box(
            modifier = Modifier.weight(1f)
        ) {
            SettingsMiddleSection(context = context, modifier = Modifier.align(Alignment.TopCenter))
        }
        ButtonBottomSection(
            buttonLabel = "Gem indstillinger",
            onClick = {
                val intent = Intent(context, MainpageActivity::class.java)
                context.startActivity(intent)
            }
        )

        ButtonBottomSection(
            buttonLabel = "Log ud",
            buttonColor = Color.White,
            textColor = Color(0xFF8DA078),
            borderColor = Color(0xFF8DA078),
            onClick = {
                val intent = Intent(context, MainActivity::class.java)
                context.startActivity(intent)
            }
        )
        AdsBar()
    }
}

// Function for the middle section of the SettingsScreen.
@Composable
fun SettingsMiddleSection(context: Context, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 15.dp)
    ) {
        HeaderText(headerText = "Indstillinger")
        SettingButtons()
        Button(
            onClick = {
                val intent = Intent(context, UpgradeLoggedinActivity::class.java)
                context.startActivity(intent)
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8DA078)),
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)

        ) {
            Text(
                text = "Opgrader",
                color = Color.White,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(30.dp))
        // Checkbox for "Tilføj notifikationer"
        val checkedState = remember { mutableStateOf(false) }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 8.dp)
        ) {
            Text(
                text = "Tilføj notifikationer:",
                fontSize = 20.sp,
                modifier = Modifier.weight(1f)
            )
            Checkbox(
                checked = checkedState.value,
                onCheckedChange = { checkedState.value = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color(0xFF8DA078),
                    uncheckedColor = Color.Gray,
                    checkmarkColor = Color.White
                ),
                modifier = Modifier.padding(start = 16.dp)
            )
        }
    }
}
@Composable
fun SettingButtons() {
    Spacer(modifier = Modifier.height(40.dp))
    val tilstande = listOf(
        "Skift brugernavn",
        "Skift mailadresse",
        "Skift kodeord"
    )

    var selectedButton by remember { mutableStateOf<String?>(null) }

    tilstande.forEach { tilstand ->
        Button(
            onClick = {
                selectedButton = tilstand
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFCBCCCA)),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .border(
                    width = 2.dp,
                    color = if (selectedButton == tilstand) Color(0xFF8DA078) else Color.Transparent,
                    shape = RoundedCornerShape(20.dp)
                )
        ) {
            Text(
                text = tilstand,
                color = Color.White,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
    }
}

// Function for displaying the SettingsScreen composable in the Android Studio preview.
@Preview
@Composable
fun SettingsPreview() {
    SettingsScreen()
}