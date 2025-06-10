package com.edrees.myweather.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.edrees.myweather.R

val UrbanistFontFamily = FontFamily(
    // Thin
    Font(R.font.urbanist_thin, FontWeight.Thin, FontStyle.Normal),
    Font(R.font.urbanist_thin_italic, FontWeight.Thin, FontStyle.Italic),

    // Extra Light
    Font(R.font.urbanist_extra_light, FontWeight.ExtraLight, FontStyle.Normal),
    Font(R.font.urbanist_extra_light_italic, FontWeight.ExtraLight, FontStyle.Italic),

    // Light
    Font(R.font.urbanist_light, FontWeight.Light, FontStyle.Normal),
    Font(R.font.urbanist_light_italic, FontWeight.Light, FontStyle.Italic),

    // Regular
    Font(R.font.urbanist_regular, FontWeight.Normal, FontStyle.Normal),
    Font(R.font.urbanist_italic, FontWeight.Normal, FontStyle.Italic),

    // Medium
    Font(R.font.urbanist_medium, FontWeight.Medium, FontStyle.Normal),
    Font(R.font.urbanist_medium_italic, FontWeight.Medium, FontStyle.Italic),

    // Semi Bold
    Font(R.font.urbanist_semi_bold, FontWeight.SemiBold, FontStyle.Normal),
    Font(R.font.urbanist_semi_bold_italic, FontWeight.SemiBold, FontStyle.Italic),

    // Bold
    Font(R.font.urbanist_bold, FontWeight.Bold, FontStyle.Normal),
    Font(R.font.urbanist_bold_italic, FontWeight.Bold, FontStyle.Italic),

    // Extra Bold
    Font(R.font.urbanist_extra_bold, FontWeight.ExtraBold, FontStyle.Normal),
    Font(R.font.urbanist_extra_bold_italic, FontWeight.ExtraBold, FontStyle.Italic),

    // Black
    Font(R.font.urbanist_black, FontWeight.Black, FontStyle.Normal),
    Font(R.font.urbanist_black_italic, FontWeight.Black, FontStyle.Italic),
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)