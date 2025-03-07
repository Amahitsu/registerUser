package com.example.registeruser.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.registeruser.ui.theme.RegisterUserTheme

@Composable
fun RegisterUserMainScreen() {
    val registerUserViewModel : RegisterUserViewModel = viewModel()

    Scaffold {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            RegisterUserFields(registerUserViewModel)
        }
    }
}


@Composable
fun RegisterUserFields(registerUserViewModel: RegisterUserViewModel){

    var registerUser = registerUserViewModel.uiState.collectAsState()


    OutlinedTextField(value = "",
        onValueChange = {
                        registerUserViewModel.onUserChange(it)
        },
        singleLine = true,
        label = {
            Text(text = "User")
        },
        modifier = Modifier.fillMaxWidth()
    )

    OutlinedTextField(value = "",
        onValueChange = {
                        registerUserViewModel.onEmailChange(it)
        },
        singleLine = true,
        label = {
            Text(text = "Email")
        },
        modifier = Modifier.fillMaxWidth()

    )

    OutlinedTextField(value = "",
        onValueChange = {registerUserViewModel.onPasswordChange(it)},
        singleLine = true,
        label = {
            Text(text = "Password")
        },
        visualTransformation = PasswordVisualTransformation(),
        modifier = Modifier.fillMaxWidth()
    )

    OutlinedTextField(value = "",
        onValueChange = {registerUserViewModel.onConfirmPassword(it)},
        singleLine = true,
        label = {
            Text(text = "Password confirm")
        },
        visualTransformation = PasswordVisualTransformation(),
        modifier = Modifier.fillMaxWidth()
    )

    Button(
        modifier = Modifier.padding(16.dp),
        onClick = { /*TODO*/ }) {
        Text(text = "Register User")

    }


}

@Composable
@Preview(showSystemUi = true, showBackground = true, device = "id:Galaxy Nexus")
fun RegisterUserPreview(){
    RegisterUserTheme {
        RegisterUserMainScreen()
    }

}