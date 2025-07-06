plugins {
  alias(libs.plugins.android.application)
  alias(libs.plugins.kotlin.android)
  alias(libs.plugins.kotlin.compose)
  alias(libs.plugins.kotlinx.serialization)
  id("com.google.devtools.ksp")
  id("com.google.dagger.hilt.android")

}

android {
  namespace = "com.gks.makeupapp"
  compileSdk = 35

  defaultConfig {
    applicationId = "com.gks.makeupapp"
    minSdk = 28
    targetSdk = 35
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
}

dependencies {
  implementation("androidx.room:room-runtime:2.7.2")
  implementation("androidx.core:core-splashscreen:1.0.0")
  implementation ("androidx.compose.material:material:1.8.3")
  implementation(libs.androidx.core.ktx)
  implementation(libs.androidx.lifecycle.runtime.ktx)
  implementation(libs.androidx.activity.compose)
  implementation(platform(libs.androidx.compose.bom))
  implementation(libs.androidx.ui)
  implementation(libs.androidx.ui.graphics)
  implementation(libs.androidx.ui.tooling.preview)
  implementation(libs.androidx.material3)
  implementation(libs.coil.compose)
  implementation(libs.coil.network)
  testImplementation(libs.junit)
  androidTestImplementation(libs.androidx.junit)
  androidTestImplementation(libs.androidx.espresso.core)
  androidTestImplementation(platform(libs.androidx.compose.bom))
  androidTestImplementation(libs.androidx.ui.test.junit4)
  debugImplementation(libs.androidx.ui.tooling)
  debugImplementation(libs.androidx.ui.test.manifest)

  implementation(libs.retrofit)
  implementation(libs.okhttp)
  implementation(libs.logging.interceptor)
  implementation(libs.retrofit.converter.serialization)
  implementation(libs.kotlinx.serialization.json)

  // Jetpack Compose integration
  implementation(libs.androidx.navigation.compose)
  implementation(libs.hilt.android)
  implementation(libs.androidx.hilt.navigation.compose)
  ksp(libs.hilt.android.compiler)
  ksp("androidx.room:room-compiler:2.7.2")
}