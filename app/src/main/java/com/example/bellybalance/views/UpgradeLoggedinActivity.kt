package com.example.bellybalance.views

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape

// Function for the main screen for showing UpgradeLoggedInScreen.
// The functions TopSections, ButtonBottomSection and AdsBar is imported from the "GeneralFunctions.kt" file.
@Composable
fun UpgradeLoggedInScreen() {
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
            UpgradeLoggedInMiddleSection(context = context, modifier = Modifier.align(Alignment.TopCenter))
        }
        ButtonBottomSection(
            buttonLabel = "Tilbage til forsiden",
            buttonColor = Color.White,
            textColor = Color(0xFF8DA078),
            borderColor = Color(0xFF8DA078),
            onClick = {
                val intent = Intent(context, MainpageActivity::class.java)
                context.startActivity(intent)
            }
        )
        AdsBar()
    }
}

// Function for the middle section of the UpgradeLoggedInScreen.
@Composable
fun UpgradeLoggedInMiddleSection(context: Context, modifier: Modifier = Modifier) {
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
@Composable
fun Upgradeboxes(items: List<String>, backgroundColor: Color) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor, shape = RoundedCornerShape(8.dp))
            .height(150.dp)
    ) {
        items.forEach { item ->
            Text(
                text = "$item\n",
                color = Color.White,
                fontSize = 25.sp,
                modifier = Modifier
                    .padding(bottom = 50.dp)
                    .align(Alignment.Center)
            )
        }
    }
}

// Function for displaying the UpgradeLoggedInScreen composable in the Android Studio preview.
@Preview
@Composable
fun UpgradeLoggedInPreview() {
    UpgradeLoggedInScreen()
}