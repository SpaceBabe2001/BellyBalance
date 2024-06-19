package com.example.bellybalance.views

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Function for the main screen for showing UpgradeLoggedOutScreen.
// The functions TopSections, Backbutton and AdsBar is imported from the "GeneralFunctions.kt" file.
@Composable
fun UpgradeLoggedOutScreen() {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TopSectionWithoutButtons(context)
        Box(
            modifier = Modifier.weight(1f)
        ) {
            UpgradeLoggedOutMiddleSection(context = context, modifier = Modifier.align(Alignment.TopCenter))
        }
        ButtonBottomSection(
            buttonLabel = "Tilbage til opret bruger",
            buttonColor = Color.White,
            textColor = Color(0xFF8DA078),
            borderColor = Color(0xFF8DA078),
            onClick = {
                val intent = Intent(context, SignupActivity::class.java)
                context.startActivity(intent)
            }
        )
        AdsBar()
    }
}

// Function for the middle section of the UpgradeLoggedOutScreen.
// The function Upgradeboxes is imported from the file "UpgradeLoggedInActivity"
@Composable
fun UpgradeLoggedOutMiddleSection(context: Context, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 15.dp)
    ) {
        HeaderText(headerText = "Opgrader")
        Spacer(modifier = Modifier.height(20.dp))
        Upgradeboxes(items = listOf("Standard version"), backgroundColor = Color(0xFFD1CDCD))
        Spacer(modifier = Modifier.height(20.dp))
        Upgradeboxes(items = listOf("Premium version"), backgroundColor = Color(0xFF8DA078))
        Spacer(modifier = Modifier.height(20.dp))
        Upgradeboxes(items = listOf("Pro version"), backgroundColor = Color(0xFF606B54))
    }
}

// Function for displaying the UpgradeLoggedOutScreen composable in the Android Studio preview.
@Preview
@Composable
fun UpgradeLoggedOutPreview() {
    UpgradeLoggedOutScreen()
}