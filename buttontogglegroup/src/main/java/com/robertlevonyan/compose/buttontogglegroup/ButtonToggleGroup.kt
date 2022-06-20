package com.robertlevonyan.compose.buttontogglegroup

import android.annotation.SuppressLint
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
    val buttonModifier = Modifier.fillMaxWidth()

    GenericButtonToggleGroup(
      scope = Scope.Column,
      buttonModifier = buttonModifier,
      buttonCount = buttonCount,
      primarySelection = primarySelection,
      selectedColor = selectedColor,
      unselectedColor = unselectedColor,
      selectedTextColor = selectedTextColor,
      unselectedTextColor = unselectedTextColor,
      buttonTexts = buttonTexts,
      shape = shape,
      borderSize = borderSize,
      border = border,
      elevation = elevation,
      enabled = enabled,
      buttonHeight = buttonHeight,
      onButtonClick = onButtonClick,
    )
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
    val buttonModifier = Modifier.weight(weight = 1f)

    GenericButtonToggleGroup(
      scope = Scope.Row,
      buttonModifier = buttonModifier,
      buttonCount = buttonCount,
      primarySelection = primarySelection,
      selectedColor = selectedColor,
      unselectedColor = unselectedColor,
      selectedTextColor = selectedTextColor,
      unselectedTextColor = unselectedTextColor,
      buttonTexts = buttonTexts,
      shape = shape,
      borderSize = borderSize,
      border = border,
      elevation = elevation,
      enabled = enabled,
      buttonHeight = buttonHeight,
      onButtonClick = onButtonClick,
    )
  }
}

@SuppressLint("ModifierParameter")
@Composable
private fun GenericButtonToggleGroup(
  scope: Scope,
  buttonModifier: Modifier,
  buttonCount: Int,
  primarySelection: Int,
  selectedColor: Color,
  unselectedColor: Color,
  selectedTextColor: Color,
  unselectedTextColor: Color,
  buttonTexts: Array<String>,
  shape: CornerBasedShape,
  borderSize: Dp,
  border: BorderStroke,
  elevation: ButtonElevation,
  enabled: Boolean,
  buttonHeight: Dp,
  onButtonClick: (index: Int) -> Unit,
) {
  val squareCorner = CornerSize(0.dp)
  var selectionIndex by rememberSaveable { mutableStateOf(primarySelection) }

  repeat(buttonCount) { index ->
    val buttonShape = when (index) {
      0 -> when (scope) {
        Scope.Column -> shape.copy(bottomStart = squareCorner, bottomEnd = squareCorner)
        Scope.Row -> shape.copy(bottomEnd = squareCorner, topEnd = squareCorner)
      }
      buttonCount - 1 -> when (scope) {
        Scope.Column -> shape.copy(topStart = squareCorner, topEnd = squareCorner)
        Scope.Row -> shape.copy(topStart = squareCorner, bottomStart = squareCorner)
      }
      else -> shape.copy(all = squareCorner)
    }
    val isButtonSelected = selectionIndex == index
    val backgroundColor = if (isButtonSelected) selectedColor else unselectedColor
    val textColor = if (isButtonSelected) selectedTextColor else unselectedTextColor
    val offset = borderSize * -index

    OutlinedButton(
      modifier = buttonModifier
        .apply {
          when (scope) {
            Scope.Column -> offset(y = offset)
            Scope.Row -> offset(x = offset)
          }
        }
        .height(buttonHeight),
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

private enum class Scope {
  Column, Row
}