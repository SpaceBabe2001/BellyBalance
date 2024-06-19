package com.example.bellybalance.views

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.TextButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.*

// Function for the main screen for showing ConditionsScreen.
// The functions TopSections, ButtonBottomSection and AdsBar is imported from the "GeneralFunctions.kt" file.
@Composable
fun ConditionsScreen() {
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
            ConditionsMiddleSection(context = context, modifier = Modifier.align(Alignment.TopCenter))
        }
        ButtonBottomSection(
            buttonLabel = "Gem tilstand",
            onClick = {
                val intent = Intent(context, MainpageActivity::class.java)
                context.startActivity(intent)
            }
        )
        AdsBar()
    }
}

// Functions for the middle section of the ConditionScreen.
@Composable
fun ConditionsMiddleSection(context: Context, modifier: Modifier = Modifier) {
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
            HeaderText(headerText = "Vælg tilstand")
            Spacer(modifier = Modifier.height(10.dp))
            BodyText(bodyText = "Hvordan havde du det efter måltidet?\n\nDu kan vælge mere end én tilstand:", modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp))
            ConditionButtons(context = context)
        }
    }
}
@Composable
fun ConditionButtons(context: Context) {
    // List of conditions
    val tilstande = listOf(
        "Mavesmerter", "Oppustet", "Kvalme", "Opkast", "Hævelse", "Kløe", "Udslæt", "OK"
    )

    // Map associating each condition with an information message
    val infoMessages = mapOf(
        "Mavesmerter" to "Information om mavesmerter.",
        "Oppustet" to "Information om oppustethed.",
        "Kvalme" to "Information om kvalme.",
        "Opkast" to "Information om opkast.",
        "Hævelse" to "Information om hævelse.",
        "Kløe" to "Information om kløe.",
        "Udslæt" to "Information om udslæt.",
        "OK" to "Vælg knappen OK, hvis din Belly er in Balance"
    )

    // Iterate through each condition and create a button for it
    var selectedButtons by remember { mutableStateOf(setOf<String>()) }
    Column {
        tilstande.forEach { tilstand ->
            ConditionButtonLayout(
                text = tilstand,
                infoMessage = infoMessages[tilstand] ?: "Vælg knappen OK, hvis din Belly er in Balance",
                isSelected = selectedButtons.contains(tilstand),
                onSelect = {
                    selectedButtons = if (selectedButtons.contains(tilstand)) {
                        selectedButtons - tilstand
                    } else {
                        selectedButtons + tilstand
                    }
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
fun ConditionButtonLayout(
    text: String,
    infoMessage: String,
    isSelected: Boolean,
    onSelect: () -> Unit
) {
    var showDialog by remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(start = 35.dp)
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Button(
            onClick = { onSelect() },
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isSelected) Color(0xFF8DA078) else Color(0xFFCBCCCA)
            ),
            modifier = Modifier
                .weight(1f)
        ) {
            Text(
                text = text,
                color = Color.White,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }

        IconButton(
            onClick = { showDialog = true },
            modifier = Modifier
                .size(40.dp)
                .padding(start = 10.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Info,
                contentDescription = "Info",
                tint = Color(0xFF8DA078)
            )
        }
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Info") },
            text = { Text(infoMessage) },
            confirmButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text("OK")
                }
            }
        )
    }
}

// Function for displaying the ConditionsScreen composable in the Android Studio preview
@Preview
@Composable
fun ConditionsPreview() {
    ConditionsScreen()
}