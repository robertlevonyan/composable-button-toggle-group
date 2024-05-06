plugins {
  id("com.android.application")
  kotlin("android")
}


android {

  compileSdk = 34
  defaultConfig {
    applicationId = "com.robertlevonyan.compose.buttontogglegroup"
    minSdk = 21
    targetSdk = 34
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
  packagingOptions {
    resources {
      excludes.add("/META-INF/{AL2.0,LGPL2.1}")
    }
  }
  namespace = "com.robertlevonyan.compose.buttontogglegroup"
}

dependencies {
  implementation("androidx.core:core-ktx:1.13.1")
  implementation("androidx.compose.ui:ui:1.6.7")
  implementation("androidx.compose.material3:material3:1.2.1")
  implementation("androidx.compose.ui:ui-tooling-preview:1.6.7")
  implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
  implementation("androidx.activity:activity-compose:1.9.0")
  implementation(project(mapOf("path" to ":buttontogglegroup")))
  debugImplementation("androidx.compose.ui:ui-tooling:1.6.7")
  debugImplementation("androidx.compose.ui:ui-test-manifest:1.6.7")
}
