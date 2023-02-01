package com.example.loginform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginform.ui.theme.LoginFormTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginFormTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                  Login()

                    }
                }
            }
        }
    }


@Composable
fun Login() {
    var username by remember {
        mutableStateOf("")
    }
        var password by remember {
            mutableStateOf("")
        }


        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(MaterialTheme.colors.background)
        )
        Column(
            Modifier
                .fillMaxSize()
                .padding(48.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LoginHeader()
            LoginFields(username, password,
                onUsernameChange = {
                    username = it
                }, onPasswordChange = {
                    password = it
                }
            )

        }
    }

  
 @Composable
 fun LoginHeader() {
     Text(
         text = "Login",
         fontSize = 36.sp,
         fontWeight = FontWeight.ExtraBold
     )
     Text(
         text = "Sign in to Continue",
         fontSize = 18.sp,
         fontWeight = FontWeight.SemiBold

     )

 }
@Composable
fun LoginFields(username: String, password: String,
                onUsernameChange: (String) -> Unit,
                onPasswordChange: (String) ->Unit){
    DemoField(value = username,
        label = username,
        placeholder = "Enter your email address ",
        onValueChange = onUsernameChange,
        trailingIcon = {
            Icon(Icons.Default.Email, contentDescription = "Email")
        })
    
    DemoField(value = password,
        label = password,
        placeholder = "Enter your password",
        onValueChange = onPasswordChange,
        visualTransformation = PasswordVisualTransformation(),
        trailingIcon = {
            Icon(Icons.Default.Lock, contentDescription ="password" )
        }
    )
}
 @Composable
 fun DemoField(value: String,
               label: String,
               placeholder:String,
               visualTransformation: VisualTransformation = VisualTransformation.None,
               keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
               trailingIcon: @Composable (() -> Unit)? = null,
               onValueChange: (String) ->Unit){
     OutlinedTextField(value = value,
         onValueChange = onValueChange,
         label = {
             Text( text = label)
         },
         placeholder =  {
             Text( text = placeholder)
         },
         visualTransformation =  visualTransformation,
         keyboardOptions = keyboardOptions,
         trailingIcon =  trailingIcon
         )

 }


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoginFormTheme {
        Login()
    }
}