plugins {
  id("com.android.application") version "7.2.1" apply false
  id("com.android.library") version "7.2.1" apply false
  id("org.jetbrains.kotlin.android") version "1.6.10" apply false
  id("com.vanniktech.maven.publish") version "0.20.0" apply false
  id("org.jetbrains.dokka") version "1.4.10.2" apply false
}

tasks.register("clean", Delete::class) {
  delete(rootProject.buildDir)
}
