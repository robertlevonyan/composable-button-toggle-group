# Composable Button Toggle Group
ComposableButtonToggleGroup is the implementation of MaterialButtonToggleGroup for Jetpack Compose

|Composable Button Toggle Group is the implementation of MaterialButtonToggleGroup for Jetpack Compose.|<img src="https://github.com/robertlevonyan/composable-button-toggle-group/blob/main/images/btg.png"  width="500" />|
|----------------------------------------------------------------------------------------------|-----------|

|Android Arsenal|[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Material%20Chip%20View-yellow.svg?style=flat-square)](https://android-arsenal.com/details/1/5396) [![API](https://img.shields.io/badge/API-21%2B-yellow.svg?style=flat-square)](https://android-arsenal.com/api?level=21)|
|--------------------|--------------------|
|Version|[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.robertlevonyan.compose/buttontogglegroup/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.robertlevonyan.compose/buttontogglegroup)|

## Setup

Add following line of code to your project level gradle file

```kotlin
  repositories {
    mavenCentral()
  }
```

Add following line of code to your module(app) level gradle file

#### Groovy:

```groovy
    implementation 'com.robertlevonyan.compose:buttontogglegroup:<Version>'
```

#### Kotlin:

```kotlin
    implementation("com.robertlevonyan.compose:buttontogglegroup:$Version")
```

#### Maven:

```xml
  <dependency>
    <groupId>com.robertlevonyan.compose</groupId>
    <artifactId>buttontogglegroup</artifactId>
    <version>Version</version>
    <type>pom</type>
  </dependency>
```

## Usage

### RowToggleButtonGroup
```kotlin
  Box(modifier = Modifier.fillMaxSize()) {
    RowToggleButtonGroup(
      modifier = Modifier,
      buttonCount = 4,
      selectedColor = Color.Gray,
      unselectedColor = LightGray,
      selectedContentColor = Color.White,
      unselectedContentColor = DarkGray,
      elevation = ButtonDefaults.elevation(0.dp), // elevation of toggle group buttons
      buttonIcons = arrayOf(
        painterResource(id = R.drawable.ic_format_align_left),
        painterResource(id = R.drawable.ic_format_align_center),
        painterResource(id = R.drawable.ic_format_align_right),
        painterResource(id = R.drawable.ic_format_align_justify),
      ),
    ) { index ->
      // check index and handle click
    }
  }
```
![alt text](https://github.com/robertlevonyan/composable-button-toggle-group/blob/main/images/row.png)


### ColumnToggleButtonGroup
```kotlin
  Box(modifier = Modifier.fillMaxSize()) {
    ColumnToggleButtonGroup(
      modifier = Modifier,
      primarySelection = 0,
      buttonCount = 2,
      selectedColor = Color.Gray,
      unselectedColor = LightGray,
      selectedContentColor = Color.White,
      unselectedContentColor = DarkGray,
      elevation = ButtonDefaults.elevation(0.dp), // elevation of toggle group buttons
      buttonTexts = arrayOf("Android", "iOS"),
      buttonIcons = arrayOf(
        painterResource(id = R.drawable.ic_android),
        painterResource(id = R.drawable.ic_ios),
      ),
    ) { index ->
      // check index and handle click
    }
  }
```
![alt text](https://github.com/robertlevonyan/composable-button-toggle-group/blob/main/images/column.png)

## Versions

#### 1.0.1 - 1.0.5

Icon button support added, Text made single line

### 1.0.0

First version of library

## Contact

- **Email**: me@robertlevonyan.com
- **Website**: https://robertlevonyan.com/
- **Medium**: https://medium.com/@RobertLevonyan
- **Twitter**: https://twitter.com/@RobertLevonyan
- **Facebook**: https://facebook.com/robert.levonyan
- **Google Play**: https://play.google.com/store/apps/dev?id=5477562049350283357

<a href="https://www.buymeacoffee.com/robertlevonyan">
  <img src="https://github.com/robertlevonyan/material-chip-view/blob/master/images/coffee.jpeg"  width="300" />
</a>

## Licence

```
    Composable Button Toggle Group©
    Copyright 2022 Robert Levonyan
    Url: https://github.com/robertlevonyan/composable-button-toggle-group

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
```
