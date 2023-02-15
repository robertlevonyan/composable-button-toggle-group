plugins {
  id("com.android.application")
  kotlin("android")
}

val composeVersion = "1.4.0"

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
    sourceCompatibility = JavaVersion.VERSION_20
    targetCompatibility = JavaVersion.VERSION_20
  }
  kotlinOptions {
    jvmTarget = "20"
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
  implementation("androidx.core:core-ktx:1.9.0")
  implementation("androidx.compose.ui:ui:$composeVersion")
  implementation("androidx.compose.material:material:$composeVersion")
  implementation("androidx.compose.ui:ui-tooling-preview:$composeVersion")
  implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")
  implementation("androidx.activity:activity-compose:1.6.1")
  implementation(project(mapOf("path" to ":buttontogglegroup")))
  debugImplementation("androidx.compose.ui:ui-tooling:$composeVersion")
  debugImplementation("androidx.compose.ui:ui-test-manifest:$composeVersion")
}
