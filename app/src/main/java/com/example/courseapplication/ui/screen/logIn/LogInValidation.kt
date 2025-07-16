package com.example.courseapplication.ui.screen.logIn

import java.util.regex.Pattern

sealed class LogInValidation {
    data class EmailError(val message: String) : LogInValidation()

    data class PasswordError(val message: String) : LogInValidation()
    data object Success : LogInValidation()
    companion object{
        private val EMAIL_REGEX = Pattern.compile(
            "[a-zA-Z0-9+._%\\-]{1,256}" +
                    "@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
        )
        private val CYRILLIC_REGEX = Pattern.compile(".*[А-Яа-яЁё].*")

        fun validateEmail(text: String): LogInValidation {
            return when {
                CYRILLIC_REGEX.matcher(text).matches() -> {
                    EmailError("Email не должен содержать кириллицу.")
                }
                text.isEmpty() -> {
                    EmailError("Email не может быть пустым.")
                }
                !EMAIL_REGEX.matcher(text).matches() -> {
                    EmailError("Неверный формат email (example@gmail.com).")
                }
                else -> {
                    Success
                }
            }
        }

        fun validatePassword(text: String): LogInValidation {
            if (text.isBlank()) {
                return PasswordError("Пароль не может быть пустым.")
            }
            return Success
        }

    }
}