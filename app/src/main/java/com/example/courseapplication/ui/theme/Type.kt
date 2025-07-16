package com.example.courseapplication.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.courseapplication.R

// Set of Material typography styles to start with

// Определяем семейство шрифтов Roboto со всеми вашими начертаниями
val RobotoFontFamily = FontFamily(
    // Normal styles
    Font(R.font.roboto_thin, FontWeight.Thin),                     // W100
    Font(R.font.roboto_extralight, FontWeight.ExtraLight),         // W200
    Font(R.font.roboto_light, FontWeight.Light),                   // W300
    Font(R.font.roboto_regular, FontWeight.Normal),                // W400
    Font(R.font.roboto_medium, FontWeight.Medium),                 // W500
    Font(R.font.roboto_semibold, FontWeight.SemiBold),             // W600
    Font(R.font.roboto_bold, FontWeight.Bold),                     // W700
    Font(R.font.roboto_extrabold, FontWeight.ExtraBold),           // W800
    Font(R.font.roboto_black, FontWeight.Black),                   // W900

    // Italic styles
    Font(R.font.roboto_thin_italic, FontWeight.Thin, FontStyle.Italic),
    Font(R.font.roboto_extralight_italic, FontWeight.ExtraLight,
        FontStyle.Italic),
    Font(R.font.roboto_lightitalic, FontWeight.Light, FontStyle.Italic), // Обратите внимание на имя файла, если это "light_italic", а не "lightitalic"
    Font(R.font.roboto_italic, FontWeight.Normal, FontStyle.Italic),      // Regular Italic
    Font(R.font.roboto_medium_italic, FontWeight.Medium, FontStyle.Italic),
    Font(R.font.roboto_semibold_italic, FontWeight.SemiBold, FontStyle.Italic),
    Font(R.font.roboto_bold_italic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.roboto_extrabold_italic, FontWeight.ExtraBold,
        FontStyle.Italic),
    Font(R.font.roboto_black_italic, FontWeight.Black, FontStyle.Italic)
)

val AppTypography = Typography(
    headlineLarge = TextStyle(
        fontFamily = RobotoFontFamily,
        fontWeight = FontWeight.W400,
        fontStyle = FontStyle.Normal,
        fontSize = 28.sp,
        lineHeight = 36.sp,
        letterSpacing = 0.sp
    ),

    titleLarge = TextStyle(
        fontFamily = RobotoFontFamily,
        fontWeight = FontWeight.W400,
        fontStyle = FontStyle.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),

    titleMedium = TextStyle(
        fontFamily = RobotoFontFamily,
        fontWeight = FontWeight.W500,
        fontStyle = FontStyle.Normal,
        fontSize = 16.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.15.sp
    ),

    bodyMedium = TextStyle(
        fontFamily = RobotoFontFamily,
        fontWeight = FontWeight.W400,
        fontStyle = FontStyle.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp
    ),

    bodySmall = TextStyle(
        fontFamily = RobotoFontFamily,
        fontWeight = FontWeight.W500,
        fontStyle = FontStyle.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.4.sp
    ),

    /*ButtonLarge*/ labelLarge = TextStyle(
        fontFamily = RobotoFontFamily,
        fontWeight = FontWeight.W500,
        fontStyle = FontStyle.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),

    /*ButtonSmall*/ labelSmall = TextStyle(
        fontFamily = RobotoFontFamily,
        fontWeight = FontWeight.W600,
        fontStyle = FontStyle.Normal,
        fontSize = 12.sp,
        lineHeight = 15.sp,
        letterSpacing = 0.4.sp
    ),

    /*Caption*/ displaySmall = TextStyle(
        fontFamily = RobotoFontFamily,
        fontWeight = FontWeight.W400,
        fontStyle = FontStyle.Normal,
        fontSize = 12.sp,
        lineHeight = 14.sp,
        letterSpacing = 0.4.sp
    )
)