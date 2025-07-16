package com.example.courseapplication.ui.screen.logIn

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.courseapplication.R
import com.example.courseapplication.ui.component.textField.EmailTextField
import com.example.courseapplication.ui.component.textField.PasswordTextField
import com.example.courseapplication.ui.component.textField.TextFieldWithHeader
import com.example.courseapplication.ui.theme.ClassmatesGradient
import com.example.courseapplication.ui.theme.VkBlue
import com.example.courseapplication.ui.theme.White

@Composable
fun LogInScreen(
    viewModel: LogInViewModel = hiltViewModel(),
    onLogInButtonClick: () -> Unit = {}
) {
    val context = LocalContext.current
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(all = 16.dp),
            contentAlignment = Alignment.CenterStart,
        ) {
            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.spacedBy(28.dp)
            ) {
                Text(text = "Вход", style = MaterialTheme.typography.headlineLarge)
                Column(
                    modifier = Modifier,
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    TextFieldWithHeader(
                        header = "Email",
                        supportingText = viewModel.emailValidationMessage?.message,
                        textField = {
                            EmailTextField(
                                value = viewModel.email,
                                placeholder = "example@gmail.com",
                                onValueChange = { viewModel.onEmailChange(it) }
                            )
                        }
                    )
                    TextFieldWithHeader(
                        header = "Пароль",
                        supportingText = viewModel.passwordValidationMessage?.message,
                        textField = {
                            PasswordTextField (
                                value = viewModel.password,
                                placeholder = "Введите пароль",
                                onValueChange = { viewModel.onPasswordChange(it) }
                            )
                        }
                    )
                }
                Button(
                    onClick = { onLogInButtonClick() },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    shape = RoundedCornerShape(30.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = White,
                        disabledContainerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
                        disabledContentColor = White.copy(alpha = 0.7f)
                    ),
                    enabled = viewModel.emailValidationMessage == null && viewModel.email.isNotEmpty() && viewModel.password.isNotEmpty()
                ) {
                    Text(
                        text = "Вход",
                        style = MaterialTheme.typography.labelLarge
                    )
                }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row {
                        Text(
                            text = "Нет аккаунта? ",
                            style = MaterialTheme.typography.labelSmall
                        )
                        Text(
                            modifier = Modifier.clickable {

                            },
                            text = "Регистрация",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                    Text(
                        modifier = Modifier.clickable {

                        },
                        text = "Забыл пароль",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
                HorizontalDivider(
                    modifier = Modifier,
                    thickness = DividerDefaults.Thickness,
                    color = DividerDefaults.color
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Button(
                        onClick = {
                            val urlIntent = Intent(
                                Intent.ACTION_VIEW,
                                ("https://vk.com/").toUri()
                            )
                            context.startActivity(urlIntent)
                        },
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp),
                        shape = RoundedCornerShape(30.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = VkBlue
                        ),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Icon(
                            modifier = Modifier.fillMaxSize(),
                            painter = painterResource(R.drawable.vk_icon),
                            contentDescription = "vk_icon",
                            tint = White
                        )
                    }
                    Button(
                        onClick = {
                            val urlIntent = Intent(
                                Intent.ACTION_VIEW,
                                ("https://ok.ru/").toUri()
                            )
                            context.startActivity(urlIntent)
                        },
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp),
                        shape = RoundedCornerShape(30.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent
                        ),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    brush = Brush.linearGradient(ClassmatesGradient),
                                    shape = RoundedCornerShape(30.dp)
                                )
                        ) {
                            Icon(
                                modifier = Modifier.fillMaxSize(),
                                painter = painterResource(R.drawable.classmates_icon),
                                contentDescription = "vk_icon",
                                tint = White
                            )
                        }
                    }
                }
            }
        }
    }
}