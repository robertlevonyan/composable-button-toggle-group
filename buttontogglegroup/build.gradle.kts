plugins {
  id("com.android.library")
  kotlin("android")
  id("com.vanniktech.maven.publish")
}

android {
  compileSdk = 33
  defaultConfig {
    minSdk = 21
    targetSdk = 33

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  buildTypes {
    release {
      isMinifyEnabled = true
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }
  kotlinOptions {
    jvmTarget = "11"
  }
  buildFeatures {
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = "1.4.2"
  }
  namespace = "com.robertlevonyan.compose"
}

dependencies {
  implementation("androidx.compose.ui:ui:1.4.0-beta01")
  implementation("androidx.compose.material:material:1.4.0-beta01")
  implementation("androidx.compose.ui:ui-tooling-preview:1.4.0-beta01")
}
