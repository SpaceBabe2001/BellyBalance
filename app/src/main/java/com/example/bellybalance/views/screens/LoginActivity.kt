package com.example.bellybalance.views.screens

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bellybalance.views.screens.ClassesAndFunctions.MainpageActivity
import com.example.bellybalance.views.screens.ClassesAndFunctions.SignupActivity
import com.example.bellybalance.views.viewModels.UserViewModel

// Function for the main screen for showing LoginScreen.
@Composable
fun LoginScreen(viewModel: UserViewModel) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE2F8DA)),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .padding(30.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(30.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
        ) {
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .background(Color(0xFFFFFFFF)),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Log ind",
                    fontSize = 36.sp,
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(40.dp))
                TextField(
                    value = email,
                    onValueChange = {email=it
                        errorMessage = ""
                    },
                    label = { Text("Email") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .background(Color.White, shape = RoundedCornerShape(8.dp))
                        .padding(5.dp)
                )
                Spacer(modifier = Modifier.height(20.dp))
                TextField(
                    value = password,
                    onValueChange = { password=it
                        errorMessage = ""
                    },
                    label = { Text("Adgangskode") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .background(Color.White, shape = RoundedCornerShape(8.dp))
                        .padding(5.dp)
                )
                Spacer(modifier = Modifier.height(30.dp))
                Button(
                    onClick = {
                        viewModel.getUser(email, password) { user ->
                            if (user != null) {
                                val intent = Intent(context, MainpageActivity::class.java)
                                context.startActivity(intent)
                            } else {
                                errorMessage = "Forkert brugernavn eller adgangskode. Prøv igen"
                            }
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8DA078)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .padding(horizontal = 5.dp)
                ) {
                    Text(
                        text = "Log ind",
                        color = Color.White,
                        fontSize = 18.sp
                    )
                }

                if (errorMessage.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = errorMessage,
                        color = Color.Red,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 10.dp)
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))
                val context = LocalContext.current
                Button(
                    onClick = {
                        val intent = Intent(context, SignupActivity::class.java)
                        context.startActivity(intent)
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .padding(horizontal = 5.dp)
                        .border(width = 2.dp, color = Color(0xFF8DA078), shape = RoundedCornerShape(22.dp))

                ) {
                    Text(
                        text = "Opret bruger",
                        color = Color(0xFF8DA078)
                    )
                }
            }
        }
    }
}
