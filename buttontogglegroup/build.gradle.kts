plugins {
  id("com.android.library")
  kotlin("android")
  id("com.vanniktech.maven.publish")
}

val composeVersion = "1.4.0"

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
  namespace = "com.robertlevonyan.compose"
}

mavenPublishing {
  publishToMavenCentral(com.vanniktech.maven.publish.SonatypeHost.S01)

  signAllPublications()
}

dependencies {
  implementation("androidx.compose.ui:ui:$composeVersion")
  implementation("androidx.compose.material:material:$composeVersion")
  implementation("androidx.compose.ui:ui-tooling-preview:$composeVersion")
}
