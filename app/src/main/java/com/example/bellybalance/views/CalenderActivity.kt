package com.example.bellybalance.views

//Inspiration for datepicker-code: https://github.com/Kiran-Bahalaskar/Date-Picker-With-Jetpack-Compose/blob/master/app/src/main/java/com/kiranbahalaskar/datepicker/MainActivity.kt

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.widget.DatePicker
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Calendar
import java.util.Date

// Function for the main screen for showing CalenderScreen.
// The functions TopSections, ButtonBottomSection and AdsBar is imported from the "GeneralFunctions.kt" file.
@Composable
fun CalenderScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        val context = LocalContext.current
        TopSection(context)
        Box(
            modifier = Modifier.weight(1f)
        ) {
            showDatePicker(context = LocalContext.current)
        }
        ButtonBottomSection(
            buttonLabel = "Se analyse",
            buttonColor = Color(0xFF8BC34A),
            onClick = {
                val intent = Intent(context, AnalyseActivity::class.java)
                context.startActivity(intent)
            }
        )
        AdsBar()
    }
}

// Functions of the white middle-section of the Calendar-Screen
@Composable
fun showDatePicker(context: Context){

    val year: Int
    val month: Int
    val day: Int

    val calendar = Calendar.getInstance()
    year = calendar.get(Calendar.YEAR)
    month = calendar.get(Calendar.MONTH)
    day = calendar.get(Calendar.DAY_OF_MONTH)
    calendar.time = Date()

    val date = remember { mutableStateOf("") }
    val showInfo = remember { mutableStateOf(false) }
    val datePickerDialog = DatePickerDialog(
        context,
        {_: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            date.value = "$dayOfMonth/${month + 1}/$year"
            showInfo.value = true
        }, year, month, day
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderText(headerText = "Min BellyBalance")
        Spacer(modifier = Modifier.height(30.dp))
        BodyText(bodyText  = "Vælg på en dato for at se, hvad du har indtaget, og hvordan du havde det.")
        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = {
                datePickerDialog.show()
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8DA078)),
            modifier = Modifier
                .padding(horizontal = 15.dp)
                .fillMaxWidth()
                .height(70.dp)
        ) {
            Text(
                text = "Vælg dato",
                color = Color.White,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.size(350.dp))
        Text(
            text = "Sådan reagerer din krop på din kost",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )

        if (showInfo.value) {
            DateInfo(date = date.value, onDismiss = {showInfo.value = false})
        }
    }
}
fun GetData(date: String): Triple<List<String>, List<String>, List<String>> {
    //Her skal der hentes data fra den pågældende dato (er givet som argument til funktionen)
    //Dataen skal gemmes i tre variable som hardcoded nedenfor (skal måske ændres til var?)

    val dataContainer1 = listOf("Havregryn", "Mælk", "Sukker", "Rugbrød")
    val dataContainer2 = listOf("Kvalme")
    val dataContainer3 = listOf("1", "6")

    return Triple(dataContainer1, dataContainer2, dataContainer3)
}
@Composable
fun DateInfo(date: String, onDismiss: () -> Unit = {}) {
    val (dataContainer1, dataContainer2, dataContainer3) = GetData(date)

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = "Den $date",
                color = Color(0xFF388E3C),
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
        },
        text = {
            Column {
                Container(title = "Spiste du...", data = dataContainer1)
                Spacer(modifier = Modifier.height(16.dp))

                Container(title = "Var dine tilstande...", data = dataContainer2)
                Spacer(modifier = Modifier.height(16.dp))

                Container(title = "Havde du type...", data = dataContainer3)
            }
        },
        confirmButton = {
            Button(
                onClick = onDismiss,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8BC34A))
            ) {
                Text(
                    text = "OK",
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        },
        containerColor = Color(0xFFFFFFFF),
    )
}
@Composable
fun Container(title: String, data: List<String>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
            .border(1.dp, Color(0xFF8BC34A))
            .padding(6.dp)
    ) {
        Text(
            text = title,
            color = Color(0xFF354033),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .height(70.dp)
        ) {
            LazyColumn(
            ) {
                items(data) { item ->
                    Text(
                        text = item,
                        color = Color(0xFF354033),
                        fontSize = 18.sp,
                        modifier = Modifier.padding(4.dp)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewShowDatePicker() {
    CalenderScreen()
}