plugins {
  id("com.android.library")
  kotlin("android")
  id("com.vanniktech.maven.publish")
}

android {
  namespace = "com.robertlevonyan.compose"
  compileSdk = 34
  defaultConfig {
    minSdk = 21
    targetSdk = 34

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
  kotlinOptions {
    jvmTarget = "17"
  }
  buildFeatures {
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = "1.5.3"
  }
}

dependencies {
  implementation("androidx.compose.ui:ui:1.5.4")
  implementation("androidx.compose.material:material:1.5.4")
  implementation("androidx.compose.ui:ui-tooling-preview:1.5.4")
}
