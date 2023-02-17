plugins {
  id("com.android.application")
  kotlin("android")
}


android {

  compileSdk = 33
  defaultConfig {
    applicationId = "com.robertlevonyan.compose.buttontogglegroup"
    minSdk = 21
    targetSdk = 33
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    vectorDrawables.useSupportLibrary = true
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
  packagingOptions {
    resources {
      excludes.add("/META-INF/{AL2.0,LGPL2.1}")
    }
  }
}

dependencies {
  implementation("androidx.core:core-ktx:1.9.0")
  implementation("androidx.compose.ui:ui:1.4.0-beta01")
  implementation("androidx.compose.material:material:1.4.0-beta01")
  implementation("androidx.compose.ui:ui-tooling-preview:1.4.0-beta01")
  implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")
  implementation("androidx.activity:activity-compose:1.6.1")
  implementation(project(mapOf("path" to ":buttontogglegroup")))
  debugImplementation("androidx.compose.ui:ui-tooling:1.4.0-beta01")
  debugImplementation("androidx.compose.ui:ui-test-manifest:1.4.0-beta01")
}
