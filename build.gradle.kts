plugins {
  id("com.android.application") version "8.4.0" apply false
  id("com.android.library") version "8.4.0" apply false
  id("com.vanniktech.maven.publish") version "0.24.0" apply false
  id("org.jetbrains.dokka") version "1.7.20" apply false
  kotlin("android") version "1.9.23" apply false
}

tasks.register("clean", Delete::class) {
  delete(layout.buildDirectory)
}
