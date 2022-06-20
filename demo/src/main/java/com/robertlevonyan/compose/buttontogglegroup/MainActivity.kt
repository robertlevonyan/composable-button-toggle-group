package com.robertlevonyan.compose.buttontogglegroup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.robertlevonyan.compose.buttontogglegroup.ui.theme.ButtonToggleGroupTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      ButtonToggleGroupTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
          BtgTest()
        }
      }
    }
  }
}

@Composable
fun BtgTest() {
  Column(modifier = Modifier.fillMaxSize()) {
    RowToggleButtonGroup(
      modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth(),
      buttonCount = 2,
      buttonTexts = arrayOf("Btn 1", "Btn 2"),
      primarySelection = 0,
    ) { index ->
      println(index)
    }

    ColumnToggleButtonGroup(
      modifier = Modifier
        .padding(16.dp)
        .fillMaxSize(fraction = 0.5f),
      primarySelection = 1,
      buttonCount = 3,
      buttonTexts = arrayOf("Btn 1", "Btn 2", "Btn 3"),
    ) { index ->
      println(index)
    }
  }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  ButtonToggleGroupTheme {
    BtgTest()
  }
}