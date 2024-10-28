plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.zpd"
    compileSdk = 34

    buildFeatures{
        dataBinding = true
        viewBinding = true
    }
    defaultConfig {
        applicationId = "com.example.zpd"
        minSdk = 24
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11

    }
//    composeOptions {
//        kotlinCompilerExtensionVersion = "1.4.4"
//    }
    kotlinOptions {
        jvmTarget = "11"
    }
}
dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.room.common)
    implementation(libs.androidx.paging.common.android)
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.paging.runtime.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation("com.mapbox.maps:android:11.7.0")
    implementation ("androidx.navigation:navigation-fragment:2.3.0")
    implementation ("androidx.navigation:navigation-ui:2.3.0")
    ksp("androidx.room:room-compiler:2.5.2")
    testImplementation("org.mockito:mockito-inline:5.0.0")
    testImplementation ("org.mockito.kotlin:mockito-kotlin:5.0.0")
    testImplementation("androidx.room:room-testing:2.5.0")

    // JUnit
    testImplementation("junit:junit:4.13.2")
    // Paging Common for testing
    testImplementation("androidx.paging:paging-common-ktx:3.1.1")
}