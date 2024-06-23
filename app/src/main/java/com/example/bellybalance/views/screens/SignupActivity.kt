package com.example.bellybalance.views.screens

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bellybalance.views.screens.ClassesAndFunctions.AdsBar
import com.example.bellybalance.views.screens.ClassesAndFunctions.ButtonBottomSection
import com.example.bellybalance.views.screens.ClassesAndFunctions.HeaderText
import com.example.bellybalance.views.screens.ClassesAndFunctions.LoginActivity
import com.example.bellybalance.views.screens.ClassesAndFunctions.TopSectionWithoutButtons
import com.example.bellybalance.views.screens.ClassesAndFunctions.UpgradeLoggedOutActivity
import com.example.bellybalance.views.viewModels.UserViewModel

@Composable
fun SignUpActivity(viewModel: UserViewModel) {
    val context = LocalContext.current
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TopSectionWithoutButtons(context)

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
                .background(Color.White)
                .padding(horizontal = 15.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.align(Alignment.TopCenter)
            ) {
                HeaderText(headerText = "Opret bruger")
                Spacer(modifier = Modifier.height(10.dp))

                Column {
                    TextField(
                        value = name,
                        onValueChange = {name =it },
                        label = { Text("Name") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .background(Color.White, shape = RoundedCornerShape(8.dp))
                    )
                    TextField(
                        value = email,
                        onValueChange = {email=it},
                        label = {Text("Email")},
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .background(Color.White, shape = RoundedCornerShape(8.dp))
                    )
                    TextField(
                        value = password,
                        onValueChange = { password=it },
                        label = { Text("Password") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .background(Color.White, shape = RoundedCornerShape(8.dp))
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                Button(
                    onClick = {
                        val intent = Intent(context, UpgradeLoggedOutActivity::class.java)
                        context.startActivity(intent)
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8DA078)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                ) {
                    Text(
                        text = "Vælg din version",
                        color = Color.White,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))
                val checkboxes = listOf(
                    "Tilføj notifikationer:",
                    "Jeg accepterer betingelserne for brug af denne app:"
                )
                val checkedStates = remember { mutableStateListOf(false, false) }
                checkboxes.forEachIndexed { index, checkboxLabel ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 15.dp, vertical = 8.dp)
                    ) {
                        Text(
                            text = checkboxLabel,
                            fontSize = 15.sp,
                            modifier = Modifier.weight(1f)
                        )

                        Checkbox(
                            checked = checkedStates[index],
                            onCheckedChange = { checkedStates[index] = it },
                            colors = CheckboxDefaults.colors(
                                checkedColor = Color(0xFF8DA078),
                                uncheckedColor = Color.Gray,
                                checkmarkColor = Color.White
                            ),
                            modifier = Modifier.padding(start = 16.dp)
                        )
                    }
                }
            }
        }

        ButtonBottomSection(
            buttonLabel = "Opret bruger",
            onClick = {
                viewModel.addUser(name,email,password, appversion="default", notification = false)
                val intent = Intent(context, LoginActivity::class.java)
                context.startActivity(intent)
            }
        )
        ButtonBottomSection(
            buttonLabel = "Tilbage til log ind",
            buttonColor = Color.White,
            textColor = Color(0xFF8DA078),
            borderColor = Color(0xFF8DA078),
            onClick = {
                val intent = Intent(context, LoginActivity::class.java)
                context.startActivity(intent)
            }
        )
        AdsBar()
    }
}
