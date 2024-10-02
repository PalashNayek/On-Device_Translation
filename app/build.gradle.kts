plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    //hilt
    alias(libs.plugins.dagger.hilt.plugin)
    alias(libs.plugins.kotlin.kapt)
}

android {
    namespace = "com.palash.on_device_translation"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.palash.on_device_translation"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures{
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    //hilt
    implementation(libs.dagger.hilt)
    kapt(libs.dagger.hilt.compiler)

    //navigation
    implementation ("androidx.navigation:navigation-fragment-ktx:2.8.0")
    implementation ("androidx.navigation:navigation-ui-ktx:2.8.0")

    //view model & live data
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")

    //coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.7.1")

    // Firebase ML Kit Translation
    /*implementation ("com.google.mlkit:translate:18.0.0")
    implementation("com.google.firebase:firebase-ml-natural-language:22.0.0")
    implementation("com.google.firebase:firebase-ml-natural-language-translate-model:20.0.8")*/
    implementation("com.google.mlkit:translate:17.0.3")

}