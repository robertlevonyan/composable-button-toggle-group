package com.robertlevonyan.compose.buttontogglegroup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.robertlevonyan.compose.buttontogglegroup.ui.theme.ButtonToggleGroupTheme
import com.robertlevonyan.compose.buttontogglegroup.ui.theme.DarkGray
import com.robertlevonyan.compose.buttontogglegroup.ui.theme.LightGray

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
      buttonCount = 4,
      selectedColor = Color.Gray,
      unselectedColor = LightGray,
      selectedContentColor = Color.White,
      unselectedContentColor = DarkGray,
      elevation = ButtonDefaults.elevation(0.dp),
      buttonIcons = arrayOf(
        painterResource(id = R.drawable.ic_format_align_left),
        painterResource(id = R.drawable.ic_format_align_center),
        painterResource(id = R.drawable.ic_format_align_right),
        painterResource(id = R.drawable.ic_format_align_justify),
      ),
    ) { index ->
      println(index)
    }

    ColumnToggleButtonGroup(
      modifier = Modifier
        .padding(16.dp)
        .fillMaxSize(fraction = 0.5f),
      primarySelection = 0,
      buttonCount = 2,
      selectedColor = Color.Gray,
      unselectedColor = LightGray,
      selectedContentColor = Color.White,
      unselectedContentColor = DarkGray,
      elevation = ButtonDefaults.elevation(0.dp),
      buttonTexts = arrayOf("Android", "iOS"),
      buttonIcons = arrayOf(
        painterResource(id = R.drawable.ic_android),
        painterResource(id = R.drawable.ic_ios),
      ),
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