package com.robertlevonyan.compose.buttontogglegroup

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ColumnToggleButtonGroup(
  modifier: Modifier = Modifier,
  buttonCount: Int,
  primarySelection: Int = -1,
  selectedColor: Color = Color.White,
  unselectedColor: Color = Color.Transparent,
  selectedTextColor: Color = Color.Black,
  unselectedTextColor: Color = Color.Gray,
  borderColor: Color = selectedColor,
  buttonTexts: Array<String> = Array(buttonCount) { "" },
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
      val textColor = if (isButtonSelected) selectedTextColor else unselectedTextColor
      val offset = borderSize * -index

      OutlinedButton(
        modifier = Modifier
          .fillMaxWidth()
          .height(buttonHeight)
          .offset(y = offset),
        contentPadding = PaddingValues(),
        shape = buttonShape,
        border = border,
        onClick = {
          selectionIndex = index
          onButtonClick.invoke(index)
        },
        colors = ButtonDefaults.outlinedButtonColors(backgroundColor = backgroundColor),
        elevation = elevation,
        enabled = enabled,
      ) {
        Text(
          text = buttonTexts[index],
          color = textColor
        )
      }
    }
  }
}

@Composable
fun RowToggleButtonGroup(
  modifier: Modifier = Modifier,
  buttonCount: Int,
  primarySelection: Int = -1,
  selectedColor: Color = Color.White,
  unselectedColor: Color = Color.Transparent,
  selectedTextColor: Color = Color.Black,
  unselectedTextColor: Color = Color.Gray,
  borderColor: Color = selectedColor,
  buttonTexts: Array<String> = Array(buttonCount) { "" },
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
      val textColor = if (isButtonSelected) selectedTextColor else unselectedTextColor
      val offset = borderSize * -index

      OutlinedButton(
        modifier = Modifier
          .weight(weight = 1f)
          .height(buttonHeight)
          .offset(x = offset),
        contentPadding = PaddingValues(),
        shape = buttonShape,
        border = border,
        onClick = {
          selectionIndex = index
          onButtonClick.invoke(index)
        },
        colors = ButtonDefaults.outlinedButtonColors(backgroundColor = backgroundColor),
        elevation = elevation,
        enabled = enabled,
      ) {
        Text(
          text = buttonTexts[index],
          color = textColor
        )
      }
    }
  }
}
