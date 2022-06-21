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
|```kotlin
  Column(modifier = Modifier.fillMaxSize()) {
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
```|![alt text](https://github.com/robertlevonyan/composable-button-toggle-group/blob/main/images/row.png)|
|--|--|
