plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
//    alias(libs.plugins.dagger.hilt.android)
//    alias(libs.plugins.kapt)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "dev.k.ui"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

//    implementation(platform(libs.androidx.compose.bom))
//
//    implementation(libs.androidx.core.ktx)
//    implementation(libs.androidx.lifecycle.runtime.ktx)
//    implementation(libs.androidx.activity.compose)
//
//    implementation(libs.androidx.lifecycle.viewmodel.ktx)
//    implementation(libs.androidx.lifecycle.viewmodel.compose)
//
//    implementation(libs.kotlinx.coroutines.android)
//
//    implementation(projects.features.newsMain.uiLogic)
//    implementation(projects.core.uikit)
//
//    implementation(libs.dagger.hilt.android)
//    kapt(libs.dagger.hilt.compiler)
//
//    implementation(libs.coil.compose)
//    implementation(projects.core.common)
}