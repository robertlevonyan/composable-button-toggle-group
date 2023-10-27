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
    kotlinCompilerExtensionVersion = "1.5.3"
  }
  packagingOptions {
    resources {
      excludes.add("/META-INF/{AL2.0,LGPL2.1}")
    }
  }
  namespace = "com.robertlevonyan.compose.buttontogglegroup"
}

dependencies {
  implementation("androidx.core:core-ktx:1.12.0")
  implementation("androidx.compose.ui:ui:1.5.4")
  implementation("androidx.compose.material:material:1.5.4")
  implementation("androidx.compose.ui:ui-tooling-preview:1.5.4")
  implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
  implementation("androidx.activity:activity-compose:1.8.0")
  implementation(project(mapOf("path" to ":buttontogglegroup")))
  debugImplementation("androidx.compose.ui:ui-tooling:1.5.4")
  debugImplementation("androidx.compose.ui:ui-test-manifest:1.5.4")
}
