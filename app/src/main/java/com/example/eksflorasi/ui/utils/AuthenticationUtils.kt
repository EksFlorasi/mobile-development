package com.example.eksflorasi.ui.utils

import androidx.compose.runtime.MutableState

fun validateName(name: String, nameErrorState: MutableState<String>) {
    if (name.length <= 0) {
        nameErrorState.value = "Please input your name"
    } else {
        nameErrorState.value = ""
    }
}

fun validateLocation(location: String, locationErrorState: MutableState<String>) {
    if (location.length <= 0) {
        locationErrorState.value = "Please input your location"
    } else {
        locationErrorState.value = ""
    }
}

fun validateEmail(email: String, emailErrorState: MutableState<String>) {
    val emailFormatRegex = Regex("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")

    if (email.length <= 0) {
        emailErrorState.value = "Please input your email"
    } else if (!email.matches(emailFormatRegex)) {
        emailErrorState.value = "Invalid email format"
    } else {
        emailErrorState.value = ""
    }
}

fun validatePassword(password: String, passwordErrorState: MutableState<String>) {
    if (password.length <= 0) {
        passwordErrorState.value = "Please input your password"
    } else if (password.length < 8) {
        passwordErrorState.value = "Password must be at least 8 characters long"
    } else {
        passwordErrorState.value = ""
    }
}

fun validateConfirmPassword(
    confirmPassword: String,
    password: String,
    confirmPasswordErrorState: MutableState<String>
) {
    if (confirmPassword.length <= 0) {
        confirmPasswordErrorState.value = "Please input your password confirmation"
    } else if (confirmPassword != password) {
        confirmPasswordErrorState.value = "Password and confirmation password do not match"
    } else {
        confirmPasswordErrorState.value = ""
    }
}

fun updateLoginEnabled(
    emailError: String,
    passwordError: String,
    isLoginEnabled: MutableState<Boolean>
) {
    isLoginEnabled.value = emailError.isEmpty() && passwordError.isEmpty()
}

fun updateRegisterEnabled(
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