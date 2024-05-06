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
    kotlinCompilerExtensionVersion = "1.5.11"
  }
}

dependencies {
  implementation("androidx.compose.ui:ui:1.6.7")
  implementation("androidx.compose.material3:material3:1.2.1")
  implementation("androidx.compose.ui:ui-tooling-preview:1.6.7")
}
