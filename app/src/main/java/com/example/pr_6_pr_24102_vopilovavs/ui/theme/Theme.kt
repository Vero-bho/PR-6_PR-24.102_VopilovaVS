package com.example.pr_6_pr_24102_vopilovavs.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

private val LightColors = lightColorScheme(
    primary = Color(0xFF6A1B9A),
    onPrimary = Color(0xFFFFFFFF),
    secondary = Color(0xFF8E24AA),
    onSecondary = Color(0xFFFFFFFF),
    tertiary = Color(0xFFAD1457),
    onTertiary = Color(0xFFFFFFFF),
    background = Color(0xFFFFF8FF),
    onBackground = Color(0xFF211A24),
    surface = Color(0xFFFFFFFF),
    onSurface = Color(0xFF211A24)
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFFFF5CA8),
    onPrimary = Color(0xFF3D0022),
    secondary = Color(0xFFFF80AB),
    onSecondary = Color(0xFF4A001F),
    tertiary = Color(0xFFE040FB),
    onTertiary = Color(0xFF2A0030),
    background = Color(0xFF0B090B),
    onBackground = Color(0xFFF2EAF0),
    surface = Color(0xFF171217),
    onSurface = Color(0xFFF2EAF0)
)

private val AppTypography = Typography(
    headlineSmall = TextStyle(
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        lineHeight = 30.sp
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        lineHeight = 26.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp
    )
)

@Composable
fun PR6_PR24102_VopilovaVSTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColors else LightColors,
        typography = AppTypography,
        content = content
    )
}