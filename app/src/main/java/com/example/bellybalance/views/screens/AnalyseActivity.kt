package com.example.bellybalance.views.screens

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.bellybalance.views.screens.ClassesAndFunctions.AdsBar
import com.example.bellybalance.views.screens.ClassesAndFunctions.ButtonBottomSection
import com.example.bellybalance.views.screens.ClassesAndFunctions.HeaderText
import com.example.bellybalance.views.screens.ClassesAndFunctions.MainpageActivity
import com.example.bellybalance.views.screens.ClassesAndFunctions.TopSection

// Function for the main screen for showing Analysis.
// The functions TopSections, ButtonBottomSection and AdsBar is imported from the "GeneralFunctions.kt" file.
@Composable
fun AnalysisScreen() {
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
            AnalysisMiddleSection(context = context, modifier = Modifier.align(Alignment.TopCenter))
        }
        ButtonBottomSection(
            buttonLabel = "Tilbage til forside",
            onClick = {
                val intent = Intent(context, MainpageActivity::class.java)
                context.startActivity(intent)
            }
        )
        AdsBar()
    }
}

// Function for the middle section of the Analysis screen.
@Composable
fun AnalysisMiddleSection(context: Context, modifier: Modifier = Modifier) {
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
            HeaderText(headerText = "Analyse")
            Spacer(modifier = Modifier.height(30.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
            ) {
                Column {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFFCC6B6B))
                    ) {
                        Text(
                            text = "Den krop reagerer dårligt på:",
                            color = Color.White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp) //
                        )
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .background(Color(0xFFD88E8E))
                    ) {
                        Text(
                            text = "Grøn peber\nPastinak\nSelleri\nAppelsin\nMelon",
                            color = Color.White,
                            fontSize = 20.sp,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp) //
                        )
                    }
                }
            }
        }
    }
}

// Function for displaying the AnalysisScreen composable in the Android Studio preview
@Preview
@Composable
fun AnalysisPreview() {
    AnalysisScreen()
}
