package com.example.bellybalance.views.screens

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bellybalance.R
import com.example.bellybalance.ui.theme.BellyBalanceTheme
import com.example.bellybalance.views.screens.ClassesAndFunctions.AdsBar
import com.example.bellybalance.views.screens.ClassesAndFunctions.BodyText
import com.example.bellybalance.views.screens.ClassesAndFunctions.ButtonBottomSection
import com.example.bellybalance.views.screens.ClassesAndFunctions.HeaderText
import com.example.bellybalance.views.screens.ClassesAndFunctions.LoginActivity

// Function for the main screen for showing WelcomeScreen.
// The functions ButtonBottomSection and AdsBar is imported from the "GeneralFunctions.kt" file.
@Composable
fun WelcomeScreen() {
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopSectionWelcome(modifier = Modifier.weight(1f))
        MiddleSection(
            modifier = Modifier.weight(1f)
        )
        ButtonBottomSection(
            buttonLabel = "Kom igang",
            onClick = {
                val intent = Intent(context, LoginActivity::class.java)
                context.startActivity(intent)
            }
        )
        AdsBar()
    }
}

// Function for the green topsection of the WelcomeScreen.
@Composable
fun TopSectionWelcome(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(Color(0xFFE2F8DA)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = "App Logo",
                modifier = Modifier.size(350.dp)
            )
            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}

// Function for the white middle section of the WelcomeScreen.
@Composable
fun MiddleSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        content = {
            HeaderText(headerText = "Velkommen til \n" + "BellyBalance")
            Spacer(modifier = Modifier.height(10.dp))
            BodyText(bodyText = "Appen der hjælper til at finde \n" + "balance i maven", modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp))
        }
    )
}

// Function for displaying the WelcomeScreen composable in the Android Studio preview.
@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    BellyBalanceTheme {
        WelcomeScreen()
    }
}