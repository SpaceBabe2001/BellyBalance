package com.example.bellybalance.views

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext

// Function for the main screen for showing resultsScreen.
// The functions TopSections, ButtonBottomSection og AdsBar is imported from the "GeneralFunctions.kt" file.
@Composable
fun ResultsScreen() {
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
            ResultsMiddleSection(context = context, modifier = Modifier.align(Alignment.TopCenter))
        }
        ButtonBottomSection(
            buttonLabel = "Analyse",
            onClick = {
                val intent = Intent(context, AnalyseActivity::class.java)
                context.startActivity(intent)
            }
        )
        AdsBar()
    }
}

// Function for the middle section of the ResultsScreen.
@Composable
fun ResultsMiddleSection(context: Context, modifier: Modifier = Modifier) {
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
            HeaderText(headerText = "Resultater")
        }
    }
}

// Function for displaying the ResultsScreen composable in the Android Studio preview.
@Preview
@Composable
fun ResultsPreview() {
    ResultsScreen()
}

