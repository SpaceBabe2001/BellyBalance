package com.example.bellybalance.views.screens

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.*
import com.example.bellybalance.R
import com.example.bellybalance.views.screens.ClassesAndFunctions.AdsBar
import com.example.bellybalance.views.screens.ClassesAndFunctions.BodyText
import com.example.bellybalance.views.screens.ClassesAndFunctions.ButtonBottomSection
import com.example.bellybalance.views.screens.ClassesAndFunctions.HeaderText
import com.example.bellybalance.views.screens.ClassesAndFunctions.MainpageActivity
import com.example.bellybalance.views.screens.ClassesAndFunctions.StoolChartActivity
import com.example.bellybalance.views.screens.ClassesAndFunctions.TimeInputSection
import com.example.bellybalance.views.screens.ClassesAndFunctions.TopSection

// Function for the main screen for showing PoopScreen.
// The functions TopSections, ButtonBottomSection og AdsBar is imported from the "GeneralFunctions.kt" file.
@Composable
fun PoopScreen() {
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
            PoopMiddleSection(context = context, modifier = Modifier.align(Alignment.TopCenter))
        }
        ButtonBottomSection(
            buttonLabel = "Gem afføring",
            onClick = {
                val intent = Intent(context, MainpageActivity::class.java)
                context.startActivity(intent)
            }
        )
        AdsBar()
    }
}

// Functions for the middle section of the PoopScreen.
@Composable
fun PoopMiddleSection(context: Context, modifier: Modifier = Modifier) {
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
            HeaderText(headerText = "Tilføj afføring")
            Spacer(modifier = Modifier.height(20.dp))
            BodyText(bodyText = "Hvornår var du sidst på toilettet?")
            Spacer(modifier = Modifier.height(20.dp))
            TimeInputSection()
            Spacer(modifier = Modifier.height(30.dp))
            BodyText(bodyText = "Hvilken type afføring havde du?")
            Spacer(modifier = Modifier.height(10.dp))

            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp)
            ) {
                PoopTypes()
            }
            Spacer(modifier = Modifier.height(45.dp))
            InfoSection()
        }
    }
}
@Composable
fun PoopTypes() {
    var selectedType by remember { mutableStateOf("Type 1") }

    Column {
        PointListItem("Type 1", isChecked = selectedType == "Type 1") { selectedType = "Type 1" }
        PointListItem("Type 2", isChecked = selectedType == "Type 2") { selectedType = "Type 2" }
        PointListItem("Type 3", isChecked = selectedType == "Type 3") { selectedType = "Type 3" }
        PointListItem("Type 4", isChecked = selectedType == "Type 4") { selectedType = "Type 4" }
        PointListItem("Type 5", isChecked = selectedType == "Type 5") { selectedType = "Type 5" }
        PointListItem("Type 6", isChecked = selectedType == "Type 6") { selectedType = "Type 6" }
        PointListItem("Type 7", isChecked = selectedType == "Type 7") { selectedType = "Type 7" }
    }
}
@Composable
fun PointListItem(text: String, isChecked: Boolean, onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(vertical = 8.dp)
            .clickable { onClick() }
    ) {
        Box(
            modifier = Modifier
                .size(24.dp)
                .background(
                    if (isChecked) Color(0xFF8DA078) else Color.Gray.copy(alpha = 0.3f),
                    shape = CircleShape
                )
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal
        )
    }
}
@Composable
fun InfoSection() {
    val context = LocalContext.current
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Klik på iconet for\nat se afføringsskema:",
            color = Color.Black,
            fontSize = 20.sp,
        )
        Spacer(modifier = Modifier.width(8.dp))
        Button(
            onClick = {
                val intent = Intent(context, StoolChartActivity::class.java)
                context.startActivity(intent)
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            modifier = Modifier.size(100.dp)        ) {
            Image(
                imageVector = Icons.Default.Info,
                contentDescription = "Skema",
                modifier = Modifier
                    .fillMaxSize()
            )
        }
    }
}

// Function for displaying the PoopScreen composable in the Android Studio preview.
@Preview
@Composable
fun PoopPreview() {
    PoopScreen()
}

