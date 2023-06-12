package com.example.eksflorasi.ui.authentication

import android.text.style.ClickableSpan
import android.view.View
import android.widget.ScrollView
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
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

@Composable
fun RegisterScreen() {
    val nameErrorState = remember { mutableStateOf("") }
    val locationErrorState = remember { mutableStateOf("") }
    val emailErrorState = remember { mutableStateOf("") }
    val passwordErrorState = remember { mutableStateOf("") }
    val confirmPasswordErrorState = remember { mutableStateOf("") }
    val isRegisterEnabled = remember { mutableStateOf(false) }

    val nameState = remember { mutableStateOf("") }
    val locationState = remember { mutableStateOf("") }
    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }
    val confirmPasswordState = remember { mutableStateOf("") }

    val state = rememberScrollState()
    LaunchedEffect(Unit) { state.animateScrollTo(10) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp).fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.eksflorasi_icon),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .size(120.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Text(
                text = stringResource(R.string.register_headline),
                style = MaterialTheme.typography.headlineLarge,
                color = Color.Black,
                modifier = Modifier.padding(vertical = 16.dp)
            )

            OutlinedTextField(
                value = nameState.value,
                onValueChange = { newValue ->
                    nameState.value = newValue
                    validateName(nameState.value, nameErrorState)
                    updateRegisterEnabled(
                        nameErrorState.value,
                        locationErrorState.value,
                        emailErrorState.value,
                        passwordErrorState.value,
                        confirmPasswordState.value,
                        isRegisterEnabled
                    )
                },
                label = {
                    var labelColor = MaterialTheme.colorScheme.onSurfaceVariant
                    if (nameErrorState.value.isNotEmpty()) {
                        labelColor = MaterialTheme.colorScheme.error
                    }
                    Text(
                        text = stringResource(R.string.name),
                        style = MaterialTheme.typography.bodyLarge,
                        color = labelColor
                    )
                },
                isError = nameErrorState.value.isNotEmpty(),
                supportingText = {
                    if (nameErrorState.value.isNotEmpty()) {
                        Text(
                            text = nameErrorState.value,
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                },
                trailingIcon = {
                    if (nameErrorState.value.isNotEmpty()) {
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
                singleLine = true
            )

            OutlinedTextField(
                value = emailState.value,
                onValueChange = { newValue ->
                    emailState.value = newValue
                    validateEmail(newValue, emailErrorState)
                    updateRegisterEnabled(
                        nameErrorState.value,
                        locationErrorState.value,
                        emailErrorState.value,
                        passwordErrorState.value,
                        confirmPasswordState.value,
                        isRegisterEnabled
                    )
                },
                label = {
                    var labelColor = MaterialTheme.colorScheme.onSurfaceVariant
                    if (emailErrorState.value.isNotEmpty()) {
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

            OutlinedTextField(
                value = passwordState.value,
                onValueChange = { newValue ->
                    passwordState.value = newValue
                    validatePassword(newValue, passwordErrorState)
                    updateRegisterEnabled(
                        nameErrorState.value,
                        locationErrorState.value,
                        emailErrorState.value,
                        passwordErrorState.value,
                        confirmPasswordState.value,
                        isRegisterEnabled
                    )
                },
                label = {
                    var labelColor = MaterialTheme.colorScheme.onSurfaceVariant
                    if (passwordErrorState.value.isNotEmpty()) {
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

            OutlinedTextField(
                value = passwordState.value,
                onValueChange = { newValue ->
                    passwordState.value = newValue
                    validatePassword(newValue, passwordErrorState)
                    updateRegisterEnabled(
                        nameErrorState.value,
                        locationErrorState.value,
                        emailErrorState.value,
                        passwordErrorState.value,
                        confirmPasswordState.value,
                        isRegisterEnabled
                    )
                },
                label = {
                    var labelColor = MaterialTheme.colorScheme.onSurfaceVariant
                    if (passwordErrorState.value.isNotEmpty()) {
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

            OutlinedTextField(
                value = confirmPasswordState.value,
                onValueChange = { newValue ->
                    confirmPasswordState.value = newValue
                    validateConfirmPassword(confirmPasswordState.value, passwordState.value, confirmPasswordErrorState)
                    updateRegisterEnabled(
                        nameErrorState.value,
                        locationErrorState.value,
                        emailErrorState.value,
                        passwordErrorState.value,
                        confirmPasswordState.value,
                        isRegisterEnabled
                    )
                },
                label = {
                    var labelColor = MaterialTheme.colorScheme.onSurfaceVariant
                    if (confirmPasswordState.value.isNotEmpty()) {
                        labelColor = MaterialTheme.colorScheme.error
                    }
                    Text(
                        style = MaterialTheme.typography.bodyLarge,
                        text = stringResource(R.string.confirm_password),
                        color = labelColor
                    )
                },
                visualTransformation = PasswordVisualTransformation(),
                isError = confirmPasswordState.value.isNotEmpty(),
                supportingText = {
                    if (confirmPasswordState.value.isNotEmpty()) {
                        Text(
                            text = confirmPasswordState.value,
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

            Button(
                onClick = { /* Log In button click action */ },
                modifier = Modifier
                    .width(256.dp)
                    .height(56.dp)
                    .padding(top = 16.dp),
                enabled = isRegisterEnabled.value,
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

private fun validateName(name: String, nameErrorState: MutableState<String>) {
    if (name.length <= 0) {
        nameErrorState.value = "Please input your name"
    } else {
        nameErrorState.value = ""
    }
}

private fun validateLocation(location: String, locationErrorState: MutableState<String>) {
    if (location.length <= 0) {
        locationErrorState.value = "Please input your location"
    } else {
        locationErrorState.value = ""
    }
}

private fun validateEmail(email: String, emailErrorState: MutableState<String>) {
    val emailFormatRegex = Regex("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")

    if (email.length <= 0) {
        emailErrorState.value = "Please input your email"
    } else if (!email.matches(emailFormatRegex)) {
        emailErrorState.value = "Invalid email format"
    } else {
        emailErrorState.value = ""
    }
}

private fun validatePassword(password: String, passwordErrorState: MutableState<String>) {
    if (password.length <= 0) {
        passwordErrorState.value = "Please input your password"
    } else if (password.length < 8) {
        passwordErrorState.value = "Password must be at least 8 characters long"
    } else {
        passwordErrorState.value = ""
    }
}

private fun validateConfirmPassword(confirmPassword: String, password: String, confirmPasswordErrorState: MutableState<String>) {
    if (confirmPassword.length <= 0) {
        confirmPasswordErrorState.value = "Please input your password confirmation"
    } else if (confirmPassword != password) {
        confirmPasswordErrorState.value = "Password and confirmation password do not match"
    } else {
        confirmPasswordErrorState.value = ""
    }
}

private fun updateRegisterEnabled(
    nameError: String,
    locationError: String,
    emailError: String,
    passwordError: String,
    confirmPasswordError: String,
    isRegisterEnabled: MutableState<Boolean>
) {
    isRegisterEnabled.value =
        nameError.isEmpty() && locationError.isEmpty() && emailError.isEmpty() && passwordError.isEmpty() && confirmPasswordError.isEmpty()
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_3A
)
@Composable
fun RegisterScreenPreview() {
    EksFlorasiTheme {
        RegisterScreen()
    }
}