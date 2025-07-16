package com.example.courseapplication.ui.screen.logIn

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LogInViewModel @Inject constructor(

) : ViewModel() {

    var email by mutableStateOf("")
        private set

    var password by mutableStateOf("")
        private set

    var emailValidationMessage by mutableStateOf<LogInValidation.EmailError?>(null)
        private set

    var passwordValidationMessage by mutableStateOf<LogInValidation.PasswordError?>(null)
        private set

    fun onEmailChange(value: String) {
        email = value
        emailValidationMessage = when (val validation = LogInValidation.validateEmail(value)) {
            is LogInValidation.EmailError -> {
                validation
            }
            is LogInValidation.Success -> {
                null
            }
            is LogInValidation.PasswordError -> {
                null
            }
        }
    }

    fun onPasswordChange(value: String) {
        password = value
        passwordValidationMessage = when (val validation = LogInValidation.validatePassword(value)) {
            is LogInValidation.EmailError -> {
                null
            }
            is LogInValidation.Success -> {
                null
            }
            is LogInValidation.PasswordError -> {
                validation
            }
        }
    }

}