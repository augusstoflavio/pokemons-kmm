plugins {
    id("com.android.application")
    kotlin("android")
}

val koinversion = "3.1.2"

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.1")
    implementation("io.insert-koin:koin-core:$koinversion")
    implementation("io.insert-koin:koin-android:$koinversion")
    implementation("io.insert-koin:koin-android-compat:$koinversion")
    implementation("io.insert-koin:koin-androidx-workmanager:$koinversion")
    implementation("io.insert-koin:koin-androidx-compose:$koinversion")
    implementation("com.github.bumptech.glide:glide:4.12.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.12.0")
}

android {
    compileSdk = 31
    defaultConfig {
        applicationId = "com.example.kmm.android"
        minSdk = 21
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    viewBinding {
        isEnabled = true
    }
}