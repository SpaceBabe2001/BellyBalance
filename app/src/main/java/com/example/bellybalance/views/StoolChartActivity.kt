package com.example.bellybalance.views

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bellybalance.R

// Function for the main screen for StoolChartScreen.
// The functions TopSections, ButtonBottomSection and AdsBar is imported from the "GeneralFunctions.kt" file.
@Composable
fun StoolChartScreen() {
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
            StoolChartMiddleSection(context = context, modifier = Modifier.align(Alignment.TopCenter))
        }
        ButtonBottomSection(
            buttonLabel = "Tilbage",
            onClick = {
                val intent = Intent(context, PoopActivity::class.java)
                context.startActivity(intent)
            }
        )
        AdsBar()
    }
}

// Function for the middle section of the StoolChartScreen.
@Composable
fun StoolChartMiddleSection(context: Context, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 15.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.align(Alignment.TopCenter)
        ) {
            HeaderText(headerText = "Afføringsskema")
            Spacer(modifier = Modifier.height(20.dp))
            Image(
                painter = painterResource(R.drawable.stool),
                contentDescription = "Skema",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}

// Function for displaying the StoolChartScreen composable in the Android Studio preview.
@Preview
@Composable
fun StoolChartPreview7() {
    StoolChartScreen()
}