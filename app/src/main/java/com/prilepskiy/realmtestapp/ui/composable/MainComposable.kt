@file:OptIn(ExperimentalMaterial3Api::class)

package com.prilepskiy.realmtestapp.ui.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prilepskiy.realmtestapp.domain.model.UserModel


@Composable
fun ForgotPass(resetPass:(email:String)->Unit){
    val (showDialog, setShowDialog) =  remember { mutableStateOf(false) }
    Column() {
        Button(onClick = { setShowDialog(true) },
            Modifier.padding(10.dp),colors = ButtonDefaults.buttonColors(Color.LightGray, contentColor = Color.Black),
            border = BorderStroke(3.dp, Color.DarkGray)
        ) {
            Text("forgot your password", fontSize = 16.sp)
        }
    }
    DialogForgotPass(showDialog, setShowDialog, resetPass)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialogRegistration(showDialog: Boolean, setShowDialog: (Boolean) -> Unit,reg:(user:UserModel)->Unit){
    if (showDialog) {
        val nameState = remember { mutableStateOf(TextFieldValue()) }
        val emailState = remember { mutableStateOf(TextFieldValue()) }
        val passwordState = remember { mutableStateOf(TextFieldValue()) }
        val addressState= remember { mutableStateOf(TextFieldValue()) }

        AlertDialog(
            onDismissRequest = {
            },
            title = {
                Text("Registration")
            },
            confirmButton = {
                Button(
                    onClick = {
                        reg(
                            UserModel(
                                name = nameState.value.text,
                                email=  emailState.value.text,
                                pass=passwordState.value.text,
                                address = addressState.value.text
                            ))
                        setShowDialog(false)
                    },
                ) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                Button(
                    onClick = {
                        setShowDialog(false)
                    },
                ) {
                    Text("Dismiss")
                }
            },
            text = {
                Column(Modifier.padding(25.dp)) {
                    Text(text = "Name")

                    TextField(
                        value = nameState.value,
                        onValueChange = { nameState.value = it },
                        label = { Text(text = "Name") },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text
                        )
                    )
                    Text(text = "Email")

                    TextField(
                        value = emailState.value,
                        onValueChange = { emailState.value = it },
                        label = { Text(text = "Email") },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email
                        )
                    )
                    Text(text = "Password")

                    TextField(
                        value = passwordState.value,
                        onValueChange = { passwordState.value = it },
                        label = { Text(text = "Password") },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password
                        )
                    )
                    Text(text = "Address")

                    TextField(
                        value = addressState.value,
                        onValueChange = { addressState.value = it },
                        label = { Text(text = "Address") },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text
                        )
                    )
                }
            },
        )
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialogForgotPass(showDialog: Boolean, setShowDialog: (Boolean) -> Unit,resetPass:(email:String)->Unit){
    if (showDialog) {
        AlertDialog(
            onDismissRequest = {
            },
            title = {
                Text("Reset password")
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
                        setShowDialog(false)
                    },
                ) {
                    Text("Dismiss")
                }
            },
            text = {
                Column(Modifier.padding(25.dp)) {
                    val textStateLogin = remember { mutableStateOf(TextFieldValue()) }
                    val textStatePassword = remember { mutableStateOf(TextFieldValue()) }

                    Text(text = "Login/Email")

                    TextField(
                        value = textStateLogin.value,
                        onValueChange = { textStateLogin.value = it },
                        label = { Text(text = "Email") },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email
                        )
                    )

                    Text(text = "default password = root12345")

                }
            },
        )
    }
}

@Composable
fun LoginContent(login:(email:String)->Unit){
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
        login(textState.value.text)
    }
}

@Composable
fun PasswordContent(pass:(email:String)->Unit){
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

        //var result = ""
       // var textColor = Color.Red
       pass(password.value.text)

}
}
@Composable
fun RegistrationLoginContent(login:()->Unit,reg:(user:UserModel)->Unit){
    val (showDialog, setShowDialog) =  remember { mutableStateOf(false) }
    Row(
        Modifier
            .padding(16.dp)
            .fillMaxWidth(), Arrangement.Center) {
        Button(onClick = { login() },Modifier.padding(25.dp)) {
            Text("Login", fontSize = 20.sp)
        }
        Button(onClick = {
            setShowDialog(true)
        },Modifier.padding(25.dp)) {
            Text("Regis", fontSize = 20.sp)
        }
    }
    DialogRegistration(showDialog, setShowDialog,reg)
}
