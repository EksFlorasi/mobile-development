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
import com.example.eksflorasi.ui.utils.*

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
        RegisterContent(
            nameState = nameState,
            emailState = emailState,
            passwordState = passwordState,
            confirmPasswordState = confirmPasswordState,
            nameErrorState = nameErrorState,
            locationErrorState = locationErrorState,
            emailErrorState = emailErrorState,
            passwordErrorState = passwordErrorState,
            confirmPasswordErrorState = confirmPasswordErrorState,
            isRegisterEnabled = isRegisterEnabled
        )
    }
}

@Composable
fun RegisterContent(
    nameState: MutableState<String>,
    emailState: MutableState<String>,
    passwordState: MutableState<String>,
    confirmPasswordState: MutableState<String>,
    nameErrorState: MutableState<String>,
    locationErrorState: MutableState<String>,
    emailErrorState: MutableState<String>,
    passwordErrorState: MutableState<String>,
    confirmPasswordErrorState: MutableState<String>,
    isRegisterEnabled: MutableState<Boolean>
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
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

        NameInput(
            nameState = nameState,
            nameErrorState = nameErrorState,
            locationErrorState = locationErrorState,
            emailErrorState = emailErrorState,
            passwordErrorState = passwordErrorState,
            confirmPasswordErrorState = confirmPasswordErrorState,
            isRegisterEnabled = isRegisterEnabled
        )

        EmailInput(
            emailState = emailState,
            nameErrorState = nameErrorState,
            locationErrorState = locationErrorState,
            emailErrorState = emailErrorState,
            passwordErrorState = passwordErrorState,
            confirmPasswordErrorState = confirmPasswordErrorState,
            isRegisterEnabled = isRegisterEnabled
        )

        PasswordInput(
            passwordState = passwordState,
            nameErrorState = nameErrorState,
            locationErrorState = locationErrorState,
            emailErrorState = emailErrorState,
            passwordErrorState = passwordErrorState,
            confirmPasswordErrorState = confirmPasswordErrorState,
            isRegisterEnabled = isRegisterEnabled
        )

        ConfirmPasswordInput(
            confirmPasswordState = confirmPasswordState,
            passwordState = passwordState,
            nameErrorState = nameErrorState,
            locationErrorState = locationErrorState,
            emailErrorState = emailErrorState,
            passwordErrorState = passwordErrorState,
            confirmPasswordErrorState = confirmPasswordErrorState,
            isRegisterEnabled = isRegisterEnabled
        )

        RegisterButton(isRegisterEnabled = isRegisterEnabled)

        LoginClickableText()
    }
}

@Composable
fun NameInput(
    nameState: MutableState<String>,
    nameErrorState: MutableState<String>,
    locationErrorState: MutableState<String>,
    emailErrorState: MutableState<String>,
    passwordErrorState: MutableState<String>,
    confirmPasswordErrorState: MutableState<String>,
    isRegisterEnabled: MutableState<Boolean>
) {
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
                confirmPasswordErrorState.value,
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
}

@Composable
fun EmailInput(
    emailState: MutableState<String>,
    nameErrorState: MutableState<String>,
    locationErrorState: MutableState<String>,
    emailErrorState: MutableState<String>,
    passwordErrorState: MutableState<String>,
    confirmPasswordErrorState: MutableState<String>,
    isRegisterEnabled: MutableState<Boolean>
) {
    OutlinedTextField(
        value = emailState.value,
        onValueChange = { newValue ->
            emailState.value = newValue
            validateEmail(emailState.value, emailErrorState)
            updateRegisterEnabled(
                nameErrorState.value,
                locationErrorState.value,
                emailErrorState.value,
                passwordErrorState.value,
                confirmPasswordErrorState.value,
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
}

@Composable
fun PasswordInput(
    passwordState: MutableState<String>,
    nameErrorState: MutableState<String>,
    locationErrorState: MutableState<String>,
    emailErrorState: MutableState<String>,
    passwordErrorState: MutableState<String>,
    confirmPasswordErrorState: MutableState<String>,
    isRegisterEnabled: MutableState<Boolean>
) {
    OutlinedTextField(
        value = passwordState.value,
        onValueChange = { newValue ->
            passwordState.value = newValue
            validatePassword(passwordState.value, passwordErrorState)
            updateRegisterEnabled(
                nameErrorState.value,
                locationErrorState.value,
                emailErrorState.value,
                passwordErrorState.value,
                confirmPasswordErrorState.value,
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
}

@Composable
fun ConfirmPasswordInput(
    confirmPasswordState: MutableState<String>,
    passwordState: MutableState<String>,
    nameErrorState: MutableState<String>,
    locationErrorState: MutableState<String>,
    emailErrorState: MutableState<String>,
    passwordErrorState: MutableState<String>,
    confirmPasswordErrorState: MutableState<String>,
    isRegisterEnabled: MutableState<Boolean>
) {
    OutlinedTextField(
        value = confirmPasswordState.value,
        onValueChange = { newValue ->
            confirmPasswordState.value = newValue
            validateConfirmPassword(
                confirmPasswordState.value,
                passwordState.value,
                confirmPasswordErrorState
            )
            updateRegisterEnabled(
                nameErrorState.value,
                locationErrorState.value,
                emailErrorState.value,
                passwordErrorState.value,
                confirmPasswordErrorState.value,
                isRegisterEnabled
            )
        },
        label = {
            var labelColor = MaterialTheme.colorScheme.onSurfaceVariant
            if (confirmPasswordErrorState.value.isNotEmpty()) {
                labelColor = MaterialTheme.colorScheme.error
            }
            Text(
                style = MaterialTheme.typography.bodyLarge,
                text = stringResource(id = R.string.confirm_password),
                color = labelColor
            )
        },
        visualTransformation = PasswordVisualTransformation(),
        isError = confirmPasswordErrorState.value.isNotEmpty(),
        supportingText = {
            if (confirmPasswordErrorState.value.isNotEmpty()) {
                Text(
                    text = confirmPasswordErrorState.value,
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
}

@Composable
fun RegisterButton(isRegisterEnabled: MutableState<Boolean>) {
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
}

@Composable
fun LoginClickableText() {
    val loginText = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colorScheme.primary
            )
        ) {
            append(stringResource(R.string.login))
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
            text = "Already have an account? ",
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            style = MaterialTheme.typography.bodyMedium
        )

        ClickableText(
            text = loginText,
            style = MaterialTheme.typography.titleSmall,
            onClick = { }
        )
    }
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