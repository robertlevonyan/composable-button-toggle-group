package com.robertlevonyan.compose.buttontogglegroup.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
  primary = Yellow200,
  primaryVariant = Yellow700,
  secondary = DarkGray,
)

private val LightColorPalette = lightColors(
  primary = Yellow500,
  primaryVariant = Yellow700,
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
    colors = colors,
    typography = Typography,
    shapes = Shapes,
    content = content
  )
}