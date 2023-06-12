package com.example.eksflorasi.ui.authentication

import android.text.style.ClickableSpan
import android.view.View
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.eksflorasi.R
import com.example.eksflorasi.ui.theme.EksFlorasiTheme
import kotlinx.coroutines.launch

@Composable
fun LoginScreen() {
    val emailErrorState = remember { mutableStateOf("") }
    val passwordErrorState = remember { mutableStateOf("") }
    val isLoginEnabled = remember { mutableStateOf(false) }

    var emailInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.eksflorasi_icon),
                contentDescription = null,
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Text(
                text = "Welcome Back",
                style = MaterialTheme.typography.headlineLarge,
                color = Color.Black,
                modifier = Modifier.padding(vertical = 16.dp)
            )

            OutlinedTextField(
                value = emailInput,
                onValueChange = { newValue ->
                    emailInput = newValue
                    validateEmail(newValue, emailErrorState)
                    updateLoginEnabled(
                        emailErrorState.value,
                        passwordErrorState.value,
                        isLoginEnabled
                    )
                },
                label = {
                    Text(
                        text = stringResource(id = R.string.email),
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                },
                isError = emailErrorState.value.isNotEmpty(),
                supportingText = {
                    if (emailErrorState.value.isNotEmpty()) {
                        Text(
                            text = "Please enter a valid email address.",
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                },
                trailingIcon = {
                    if (emailErrorState.value.isNotEmpty()) {
                        Icon(Icons.Filled.Error, "error", tint = MaterialTheme.colorScheme.error)
                    }
                },
                modifier = Modifier
                    .width(256.dp)
                    .padding(vertical = 8.dp),
                shape = MaterialTheme.shapes.large,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = MaterialTheme.colorScheme.outline,
                    unfocusedBorderColor = MaterialTheme.colorScheme.outlineVariant
                )
            )

            Column(
                modifier = Modifier.wrapContentWidth()
            ) {
                OutlinedTextField(
                    value = passwordInput,
                    onValueChange = { newValue ->
                        passwordInput = newValue
                        validatePassword(newValue, passwordErrorState)
                        updateLoginEnabled(
                            emailErrorState.value,
                            passwordErrorState.value,
                            isLoginEnabled
                        )
                    },
                    label = {
                        Text(
                            text = stringResource(id = R.string.password),
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    },
                    visualTransformation = PasswordVisualTransformation(),
                    isError = passwordErrorState.value.isNotEmpty(),
                    supportingText = {
                        if (passwordErrorState.value.isNotEmpty()) {
                            Text(
                                text = stringResource(R.string.password_validation),
                                color = MaterialTheme.colorScheme.error
                            )
                        }
                    },
                    modifier = Modifier
                        .width(256.dp)
                        .padding(vertical = 8.dp),
                    shape = MaterialTheme.shapes.large,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = MaterialTheme.colorScheme.outline,
                        unfocusedBorderColor = MaterialTheme.colorScheme.outlineVariant
                    )
                )

                Row(
                    horizontalArrangement = Arrangement.End
                ){
                    Text(
                        text = stringResource(R.string.forgot_password),
                        modifier = Modifier
                            .clickable { /* Forgot password click action */ },
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }

            Button(
                onClick = { /* Log In button click action */ },
                modifier = Modifier
                    .width(256.dp)
                    .height(56.dp)
                    .padding(top = 16.dp),
                enabled = isLoginEnabled.value,
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(text = stringResource(id = R.string.login))
            }

            val signUpText = buildAnnotatedString {
                withStyle(style = SpanStyle(
                    color = MaterialTheme.colorScheme.primary
                )) {
                    append("Sign up")
                }
            }

            val signUpClickableSpan = object : ClickableSpan() {
                override fun onClick(widget: View) {
                    // Handle sign up click action
                }
            }

            Row(
                modifier = Modifier.padding(top = 16.dp)
            ){
                Text(
                    text = "Don't have an account? ",
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    style = MaterialTheme.typography.bodyMedium
                )

                ClickableText(
                    text = signUpText,
                    style = MaterialTheme.typography.titleSmall,
                    onClick = { }
                )
            }

        }
    }
}

private fun validateEmail(email: String, emailErrorState: MutableState<String>) {
    val emailFormatRegex = Regex("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")

    if (!email.matches(emailFormatRegex)) {
        emailErrorState.value = "Invalid email format"
    } else {
        emailErrorState.value = ""
    }
}

private fun validatePassword(password: String, passwordErrorState: MutableState<String>) {
    if (password.length < 8) {
        passwordErrorState.value = "Password must be at least 8 characters long"
    } else {
        passwordErrorState.value = ""
    }
}

private fun updateLoginEnabled(
    emailError: String,
    passwordError: String,
    isLoginEnabled: MutableState<Boolean>
) {
    isLoginEnabled.value = emailError.isEmpty() && passwordError.isEmpty()
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_3A
)
@Composable
fun LoginScreenPreview() {
    EksFlorasiTheme {
        LoginScreen()
    }
}