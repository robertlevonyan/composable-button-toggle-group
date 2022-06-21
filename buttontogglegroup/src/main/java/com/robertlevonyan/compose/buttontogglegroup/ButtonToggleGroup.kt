package com.robertlevonyan.compose.buttontogglegroup

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ColumnToggleButtonGroup(
  modifier: Modifier = Modifier,
  buttonCount: Int,
  primarySelection: Int = -1,
  selectedColor: Color = Color.White,
  unselectedColor: Color = Color.Unspecified,
  selectedContentColor: Color = Color.Black,
  unselectedContentColor: Color = Color.Gray,
  buttonIconTint: Color = selectedContentColor,
  unselectedButtonIconTint: Color = unselectedContentColor,
  borderColor: Color = selectedColor,
  buttonTexts: Array<String> = Array(buttonCount) { "" },
  buttonIcons: Array<Painter> = Array(buttonCount) { emptyPainter },
  shape: CornerBasedShape = MaterialTheme.shapes.small,
  borderSize: Dp = 1.dp,
  border: BorderStroke = BorderStroke(borderSize, borderColor),
  elevation: ButtonElevation = ButtonDefaults.elevation(),
  enabled: Boolean = true,
  buttonHeight: Dp = 60.dp,
  onButtonClick: (index: Int) -> Unit,
) {
  Column(modifier = modifier) {
    val squareCorner = CornerSize(0.dp)
    var selectionIndex by rememberSaveable { mutableStateOf(primarySelection) }

    repeat(buttonCount) { index ->
      val buttonShape = when (index) {
        0 -> shape.copy(bottomStart = squareCorner, bottomEnd = squareCorner)
        buttonCount - 1 -> shape.copy(topStart = squareCorner, topEnd = squareCorner)
        else -> shape.copy(all = squareCorner)
      }
      val isButtonSelected = selectionIndex == index
      val backgroundColor = if (isButtonSelected) selectedColor else unselectedColor
      val contentColor = if (isButtonSelected) selectedContentColor else unselectedContentColor
      val iconTintColor = if (isButtonSelected) buttonIconTint else unselectedButtonIconTint
      val offset = borderSize * -index

      ToggleButton(
        modifier = Modifier
          .fillMaxWidth()
          .height(buttonHeight)
          .offset(y = offset),
        buttonShape = buttonShape,
        border = border,
        backgroundColor = backgroundColor,
        elevation = elevation,
        enabled = enabled,
        buttonTexts = buttonTexts,
        buttonIcons = buttonIcons,
        index = index,
        contentColor = contentColor,
        iconTintColor = iconTintColor,
        onClick = {
          selectionIndex = index
          onButtonClick.invoke(index)
        },
      )
    }
  }
}

@Composable
fun RowToggleButtonGroup(
  modifier: Modifier = Modifier,
  buttonCount: Int,
  primarySelection: Int = -1,
  selectedColor: Color = Color.White,
  unselectedColor: Color = Color.Unspecified,
  selectedContentColor: Color = Color.Black,
  unselectedContentColor: Color = Color.Gray,
  buttonIconTint: Color = selectedContentColor,
  unselectedButtonIconTint: Color = unselectedContentColor,
  borderColor: Color = selectedColor,
  buttonTexts: Array<String> = Array(buttonCount) { "" },
  buttonIcons: Array<Painter> = Array(buttonCount) { ColorPainter(Color.Transparent) },
  shape: CornerBasedShape = MaterialTheme.shapes.small,
  borderSize: Dp = 1.dp,
  border: BorderStroke = BorderStroke(borderSize, borderColor),
  elevation: ButtonElevation = ButtonDefaults.elevation(),
  enabled: Boolean = true,
  buttonHeight: Dp = 60.dp,
  onButtonClick: (index: Int) -> Unit,
) {
  Row(modifier = modifier) {
    val squareCorner = CornerSize(0.dp)
    var selectionIndex by rememberSaveable { mutableStateOf(primarySelection) }

    repeat(buttonCount) { index ->
      val buttonShape = when (index) {
        0 -> shape.copy(bottomEnd = squareCorner, topEnd = squareCorner)
        buttonCount - 1 -> shape.copy(topStart = squareCorner, bottomStart = squareCorner)
        else -> shape.copy(all = squareCorner)
      }
      val isButtonSelected = selectionIndex == index
      val backgroundColor = if (isButtonSelected) selectedColor else unselectedColor
      val contentColor = if (isButtonSelected) selectedContentColor else unselectedContentColor
      val iconTintColor = if (isButtonSelected) buttonIconTint else unselectedButtonIconTint
      val offset = borderSize * -index

      ToggleButton(
        modifier = Modifier
          .weight(weight = 1f)
          .height(buttonHeight)
          .offset(x = offset),
        buttonShape = buttonShape,
        border = border,
        backgroundColor = backgroundColor,
        elevation = elevation,
        enabled = enabled,
        buttonTexts = buttonTexts,
        buttonIcons = buttonIcons,
        index = index,
        contentColor = contentColor,
        iconTintColor = iconTintColor,
        onClick = {
          selectionIndex = index
          onButtonClick.invoke(index)
        },
      )
    }
  }
}

@Composable
private fun ToggleButton(
  modifier: Modifier,
  buttonShape: CornerBasedShape,
  border: BorderStroke,
  backgroundColor: Color,
  elevation: ButtonElevation,
  enabled: Boolean,
  buttonTexts: Array<String>,
  buttonIcons: Array<Painter>,
  index: Int,
  contentColor: Color,
  iconTintColor: Color,
  onClick: () -> Unit,
) {
  OutlinedButton(
    modifier = modifier,
    contentPadding = PaddingValues(),
    shape = buttonShape,
    border = border,
    onClick = onClick,
    colors = ButtonDefaults.outlinedButtonColors(backgroundColor = backgroundColor),
    elevation = elevation,
    enabled = enabled,
  ) {
    ButtonContent(
      buttonTexts = buttonTexts,
      buttonIcons = buttonIcons,
      index = index,
      contentColor = contentColor,
      iconTintColor = iconTintColor,
    )
  }
}

@Composable
private fun RowScope.ButtonContent(
  buttonTexts: Array<String>,
  buttonIcons: Array<Painter>,
  index: Int,
  contentColor: Color,
  iconTintColor: Color,
) {
  when {
    buttonTexts.all { it != "" } && buttonIcons.all { it != emptyPainter } -> {
      if (iconTintColor == Color.Transparent || iconTintColor == Color.Unspecified) {
        Image(
          modifier = Modifier
            .align(Alignment.CenterVertically)
            .size(24.dp),
          painter = buttonIcons[index],
          contentDescription = null,
        )
      } else {
        Image(
          modifier = Modifier
            .align(Alignment.CenterVertically)
            .size(24.dp),
          painter = buttonIcons[index],
          contentDescription = null,
          colorFilter = ColorFilter.tint(iconTintColor)
        )
      }
      Text(
        modifier = Modifier
          .padding(start = 8.dp)
          .align(Alignment.CenterVertically),
        text = buttonTexts[index],
        color = contentColor
      )
    }
    buttonTexts.all { it != "" } && buttonIcons.all { it == emptyPainter } ->
      Text(
        modifier = Modifier.align(Alignment.CenterVertically),
        text = buttonTexts[index],
        color = contentColor
      )
    buttonTexts.all { it == "" } && buttonIcons.all { it != emptyPainter } ->
      if (iconTintColor == Color.Transparent || iconTintColor == Color.Unspecified) {
        Image(
          modifier = Modifier
            .align(Alignment.CenterVertically)
            .size(24.dp),
          painter = buttonIcons[index],
          contentDescription = null,
        )
      } else {
        Image(
          modifier = Modifier
            .align(Alignment.CenterVertically)
            .size(24.dp),
          painter = buttonIcons[index],
          contentDescription = null,
          colorFilter = ColorFilter.tint(iconTintColor)
        )
      }
  }
}

private val emptyPainter = ColorPainter(Color.Transparent)