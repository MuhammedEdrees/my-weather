package com.edrees.myweather.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)
val LightBlue1 = Color(0xFF87CEFA)

@Immutable
data class CustomColors(
    val backgroundColor1: Color = Color.Unspecified,
    val backgroundColor2: Color = Color.Unspecified,
    val backgroundColor3: Color = Color.Unspecified,
    val textColor1: Color = Color.Unspecified,
    val textColor2: Color = Color.Unspecified,
    val textColor3: Color = Color.Unspecified,
    val surfaceColor1: Color = Color.Unspecified,
    val surfaceColor2: Color = Color.Unspecified,
    val dividerColor: Color = Color.Unspecified,
    val borderColor: Color = Color.Unspecified
)

val lightCustomColors = CustomColors(
    backgroundColor1 = LightBlue1,
    backgroundColor2 = Color.White,
    backgroundColor3 = Color(0xFF00619D),
    textColor1 = Color(0xFF060414),
    textColor2 = Color(0xDE060414),
    textColor3 = Color(0x99060414),
    surfaceColor1 = Color(0xB2FFFFFF),
    surfaceColor2 = Color(0x14060414),
    dividerColor = Color(0x3D060414),
    borderColor = Color(0x14060414)
)

val darkCustomColors = CustomColors(
    backgroundColor1 = Color(0xFF060414),
    backgroundColor2 = Color(0xFF0D0C19),
    backgroundColor3 = Color(0xFFC0B7FF),
    textColor1 = Color.White,
    textColor2 = Color.White.copy(alpha = 0.87f),
    textColor3 = Color.White.copy(alpha = 0.6f),
    surfaceColor1 = Color(0xB2060414),
    surfaceColor2 = Color(0x14FFFFFF),
    dividerColor = Color(0x3DFFFFFF),
    borderColor = Color(0x14FFFFFF)
)

val LocalCustomColors = staticCompositionLocalOf { CustomColors() }