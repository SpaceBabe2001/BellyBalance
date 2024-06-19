package com.example.bellybalance.views

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Function for the main screen for showing ReportsScreen.
// The functions TopSections, ButtonBottomSection and AdsBar is imported from the "GenerelFunctions.kt" file.
@Composable
fun ReportsScreen(viewModel: UserViewModel) {
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
            ReportsMiddleSection(context = context,viewModel=viewModel, modifier = Modifier.align(Alignment.TopCenter))
        }
        ButtonBottomSection(
            buttonLabel = "Min BellyBalance",
            buttonColor = Color(0xFF8BC34A),
            onClick = {
                val intent = Intent(context, CalenderActivity::class.java)
                context.startActivity(intent)
            }
        )
        ButtonBottomSection(
            buttonLabel = "Opgrader",
            buttonColor = Color(0xFF8BC34A),
            onClick = {
                val intent = Intent(context, UpgradeLoggedinActivity::class.java)
                context.startActivity(intent)
            }
        )
        AdsBar()
    }
}

// Function for the middle section of the ReportsScreen.
@Composable
fun ReportsMiddleSection(context: Context,viewModel:UserViewModel, modifier: Modifier = Modifier) {
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
            HeaderText(headerText = "BellyBalance")
            Spacer(modifier = Modifier.height(15.dp))
            viewModel.currentUser?.let { user ->
                BodyText(bodyText = "Velkommen tilbage ${user.name} \nVælg hvad du vil tracke", modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            FoodButton("Fødevarer")
            Spacer(modifier = Modifier.height(15.dp))
            PoopButton("Afføring")
            Spacer(modifier = Modifier.height(15.dp))
            ConditonButton("Tilstand")

        }
    }
}
@Composable
fun FoodButton(text: String) {
    val context = LocalContext.current
    Button(
        onClick = {
            val intent = Intent(context, FoodActivity::class.java)
            context.startActivity(intent)
        },
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8DA078)),
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
@Composable
fun PoopButton(text: String) {
    val context = LocalContext.current
    Button(
        onClick = {
            val intent = Intent(context, PoopActivity::class.java)
            context.startActivity(intent)
        },
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8DA078)),
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
@Composable
fun ConditonButton(text: String) {
    val context = LocalContext.current
    Button(
        onClick = {
            val intent = Intent(context, ConditionActivity::class.java)
            context.startActivity(intent)
        },
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8DA078)),
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
