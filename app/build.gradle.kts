plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

    alias(libs.plugins.dagger.hilt.android)
    alias(libs.plugins.kapt)
}

android {
    namespace = "dev.k.shift"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "dev.k.shift"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"

        buildConfigField(
            "String",
            "PIZZA_API_BASE_URL",
            "\"https://shift-intensive.ru/api/pizza/\""
        )

    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = libs.versions.jvmTarget.get()
    }
    buildFeatures {
        buildConfig = true
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))

    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.hilt.navigation.compose)

    implementation(libs.dagger.hilt.android)
    kapt(libs.dagger.hilt.compiler)

    implementation(project(":core-pizza:pizza-api"))
    implementation(project(":core-pizza:pizza-database"))
    implementation(project(":core-order:order-database"))
    implementation(project(":ui-kit"))
    implementation(project(":features:pizza-main:ui"))
    implementation(project(":features:cart:ui"))
    implementation(project(":features:orders:ui"))
    implementation(project(":features:profile:ui"))
    implementation(project(":features:pizza-detail:ui"))
    implementation(project(":features:make-order:ui"))
}