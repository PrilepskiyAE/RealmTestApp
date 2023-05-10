package com.prilepskiy.realmtestapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prilepskiy.realmtestapp.ui.theme.RealmTestAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RealmTestAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Container()
                }
            }
        }
    }
}

@Preview
@Composable
fun Container() {

    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(Modifier.fillMaxWidth(),verticalArrangement = Arrangement.Center,horizontalAlignment = Alignment.CenterHorizontally) {
            LoginContent()
            PasswordContent()
            RegistrationLoginContent()
            ForgotPass()

        }


    }



}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginContent(){
    Column(Modifier.padding(25.dp)) {
        Text(text = "Login/Email")
        val textState = remember { mutableStateOf(TextFieldValue()) }
        TextField(
            value = textState.value,
            onValueChange = { textState.value = it },
            label = { Text(text = "Email") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            )
        )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordContent(){
    Column(Modifier.padding(25.dp)) {
        val password = remember { mutableStateOf(TextFieldValue()) }
        Text(text = "Password")
        TextField(

            value = password.value,
            onValueChange = { password.value = it },
            label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            )

        )

        var result = "incorrect"
        var textColor = Color.Red
        if (password.value.text == "secret"){
            result = "correct"
            textColor = Color.Green
        }

        Text(
            text = "Password : $result",
            fontSize = 22.sp,
            color = textColor,
            fontFamily = FontFamily.SansSerif,
            fontStyle = FontStyle.Italic,
            modifier = Modifier.padding(top = 20.dp)
        )
    }
}
@Composable
fun RegistrationLoginContent(){
    val (showDialog, setShowDialog) =  remember { mutableStateOf(false) }
Row(Modifier.padding(16.dp).fillMaxWidth(), Arrangement.Center) {
    Button(onClick = { /*TODO*/ },Modifier.padding(25.dp)) {
        Text("Login", fontSize = 20.sp)
    }
    Button(onClick = {
        setShowDialog(true)
                     },Modifier.padding(25.dp)) {
        Text("Regis", fontSize = 20.sp)
    }
}
    DialogDemo(showDialog, setShowDialog)
}
@Composable
fun ForgotPass(){
    Column() {
    Button(onClick = { /*TODO*/ },Modifier.padding(10.dp),colors = ButtonDefaults.buttonColors(Color.LightGray, contentColor = Color.Black),
        border = BorderStroke(3.dp, Color.DarkGray)
    ) {
        Text("forgot your password", fontSize = 16.sp)
    }
}}

@Composable
fun DialogRegistration(){
    val openDialog = remember { mutableStateOf(false) }

}

@Composable
fun DialogForgotPass(){

}
@Composable
fun DialogDemo(showDialog: Boolean, setShowDialog: (Boolean) -> Unit) {
    if (showDialog) {
        AlertDialog(
            onDismissRequest = {
            },
            title = {
                Text("Title")
            },
            confirmButton = {
                Button(
                    onClick = {
                        // Change the state to close the dialog
                        setShowDialog(false)
                    },
                ) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                Button(
                    onClick = {
                        // Change the state to close the dialog
                        setShowDialog(false)
                    },
                ) {
                    Text("Dismiss")
                }
            },
            text = {
                Text("This is a text on the dialog")
            },
        )
    }
}