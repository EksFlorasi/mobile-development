package com.example.eksflorasi.ui.authentication

import android.text.style.ClickableSpan
import android.view.View
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.eksflorasi.R
import com.example.eksflorasi.ui.theme.EksFlorasiTheme
import com.example.eksflorasi.ui.utils.*

@Composable
fun LoginScreen() {
    val emailErrorState = remember { mutableStateOf("") }
    val passwordErrorState = remember { mutableStateOf("") }
    val isLoginEnabled = remember { mutableStateOf(false) }

    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }

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
                text = stringResource(R.string.login_headline),
                style = MaterialTheme.typography.headlineLarge,
                color = Color.Black,
                modifier = Modifier.padding(vertical = 16.dp)
            )

            OutlinedTextField(
                value = emailState.value,
                onValueChange = { newValue ->
                    emailState.value = newValue
                    validateEmail(newValue, emailErrorState)
                    updateLoginEnabled(
                        emailErrorState.value,
                        passwordErrorState.value,
                        isLoginEnabled
                    )
                },
                label = {
                    var labelColor = MaterialTheme.colorScheme.onSurfaceVariant
                    if (emailErrorState.value.isNotEmpty()){
                        labelColor = MaterialTheme.colorScheme.error
                    }
                    Text(
                        text = stringResource(id = R.string.email),
                        style = MaterialTheme.typography.bodyLarge,
                        color = labelColor
                    )
                },
                isError = emailErrorState.value.isNotEmpty(),
                supportingText = {
                    if (emailErrorState.value.isNotEmpty()) {
                        Text(
                            text = emailErrorState.value,
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
                    .padding(vertical = 8.dp)
                    .height(IntrinsicSize.Min),
                textStyle = MaterialTheme.typography.bodySmall,
                shape = MaterialTheme.shapes.large,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = MaterialTheme.colorScheme.outline,
                    unfocusedBorderColor = MaterialTheme.colorScheme.outlineVariant
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                singleLine = true
            )

            Column(
                modifier = Modifier.wrapContentWidth()
            ) {
                OutlinedTextField(
                    value = passwordState.value,
                    onValueChange = { newValue ->
                        passwordState.value = newValue
                        validatePassword(newValue, passwordErrorState)
                        updateLoginEnabled(
                            emailErrorState.value,
                            passwordErrorState.value,
                            isLoginEnabled
                        )
                    },
                    label = {
                        var labelColor = MaterialTheme.colorScheme.onSurfaceVariant
                        if (passwordErrorState.value.isNotEmpty()){
                            labelColor = MaterialTheme.colorScheme.error
                        }
                        Text(
                            style = MaterialTheme.typography.bodyLarge,
                            text = stringResource(id = R.string.password),
                            color = labelColor
                        )
                    },
                    visualTransformation = PasswordVisualTransformation(),
                    isError = passwordErrorState.value.isNotEmpty(),
                    supportingText = {
                        if (passwordErrorState.value.isNotEmpty()) {
                            Text(
                                text = passwordErrorState.value,
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
                ) {
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
                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.colorScheme.primary
                    )
                ) {
                    append(stringResource(R.string.register))
                }
            }

            val signUpClickableSpan = object : ClickableSpan() {
                override fun onClick(widget: View) {
                    // Handle sign up click action
                }
            }

            Row(
                modifier = Modifier.padding(top = 16.dp)
            ) {
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