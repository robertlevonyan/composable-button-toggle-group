package com.robertlevonyan.compose.buttontogglegroup.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColorScheme(
  primary = Yellow200,
  primaryContainer = Yellow700,
  secondary = DarkGray,
)

private val LightColorPalette = lightColorScheme(
  primary = Yellow500,
  primaryContainer = Yellow700,
  secondary = DarkGray,
)

@Composable
fun ButtonToggleGroupTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
  val colors = if (darkTheme) {
    DarkColorPalette
  } else {
    LightColorPalette
  }

  MaterialTheme(
    colorScheme = colors,
    typography = Typography,
    shapes = Shapes,
    content = content
  )
}