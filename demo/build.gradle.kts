plugins {
  id("com.android.application")
  kotlin("android")
}

val composeVersion = "1.1.1"

android {
  compileSdk = 32

  defaultConfig {
    applicationId = "com.robertlevonyan.compose.buttontogglegroup"
    minSdk = 21
    targetSdk = 32
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
    kotlinCompilerExtensionVersion = composeVersion
  }
  packagingOptions {
    resources {
      excludes.add("/META-INF/{AL2.0,LGPL2.1}")
    }
  }
}

dependencies {
  implementation("androidx.core:core-ktx:1.8.0")
  implementation("androidx.compose.ui:ui:$composeVersion")
  implementation("androidx.compose.material:material:$composeVersion")
  implementation("androidx.compose.ui:ui-tooling-preview:$composeVersion")
  implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.1")
  implementation("androidx.activity:activity-compose:1.4.0")
  implementation(project(mapOf("path" to ":buttontogglegroup")))
  debugImplementation("androidx.compose.ui:ui-tooling:$composeVersion")
  debugImplementation("androidx.compose.ui:ui-test-manifest:$composeVersion")
}
