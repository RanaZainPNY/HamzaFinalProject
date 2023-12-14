import org.jetbrains.kotlin.fir.expressions.FirEmptyArgumentList.arguments
import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.smartprofilemanagement"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.smartprofilemanagement"
        minSdk = 29
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

//        javaCompileOptions {
//            annotationProcessorOptions {
////                arguments += ["room.schemaLocation" : "$projectDir/schemas".toString()]
//                arguments += mapOf("room.schemaLocation" to "$projectDir/schemas".toString())
//            }
//        }
        ksp {
            arg("room.schemaLocation", "$projectDir/schemas")
        }

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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation(platform("androidx.compose:compose-bom:2023.10.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("com.google.android.gms:play-services-location:21.0.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    // Room Database
    val room_version = "2.5.2"
    implementation("androidx.room:room-runtime:$room_version")
    // optional - Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:$room_version")
    annotationProcessor("androidx.room:room-compiler:$room_version")
    implementation("androidx.room:room-rxjava2:$room_version")  // optional - RxJava2 support for Room
    implementation("androidx.room:room-rxjava3:$room_version")  // optional - RxJava3 support for Room
    implementation("androidx.room:room-guava:$room_version")  // optional - Guava support for Room, including Optional and ListenableFuture
    implementation("androidx.room:room-paging:$room_version") // optional - Paging 3 Integration
    //    testImplementation("androidx.room:room-testing:$room_version") // optional - Test helpers

    ksp("androidx.room:room-compiler:$room_version") // To use Kotlin Symbol Processing (KSP)

    // Lifecycle components
    val lifecycle_version = "2.6.2"
    val arch_version = "2.2.0"

    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version") // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycle_version") // ViewModel utilities for Compose
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")  // LiveData
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version")  // Lifecycles only (without ViewModel or LiveData)
    implementation("androidx.lifecycle:lifecycle-runtime-compose:$lifecycle_version")  // Lifecycle utilities for Compose
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycle_version") // Saved state module for ViewModel
    ksp("androidx.lifecycle:lifecycle-compiler:$lifecycle_version") // Annotation processor

    val nav_version = "2.7.3"

    implementation("androidx.navigation:navigation-runtime-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-compose:$nav_version")

    implementation("com.google.android.gms:play-services-location:21.0.1")
    implementation("com.google.maps.android:maps-ktx:5.0.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.7.3")




//    implementation("androidx.lifecycle:lifecycle-common-java8:$lifecycle_version") // alternately - if using Java8, use the following instead of lifecycle-compiler
//    implementation("androidx.lifecycle:lifecycle-service:$lifecycle_version")  // optional - helpers for implementing LifecycleOwner in a Service
//    implementation("androidx.lifecycle:lifecycle-process:$lifecycle_version")  // optional - ProcessLifecycleOwner provides a lifecycle for the whole application process
//    implementation("androidx.lifecycle:lifecycle-reactivestreams-ktx:$lifecycle_version") // optional - ReactiveStreams support for LiveData
//    testImplementation("androidx.arch.core:core-testing:$arch_version") // optional - Test helpers for LiveData
//    testImplementation ("androidx.lifecycle:lifecycle-runtime-testing:$lifecycle_version")  // optional - Test helpers for Lifecycle runtime


}




////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////


//plugins {
//    id("com.android.application")
//    id("org.jetbrains.kotlin.android")
//    id("com.google.devtools.ksp")
//}
//
//android {
//    namespace = "com.example.smartprofilemanagement"
//    compileSdk = 34
//
//    defaultConfig {
//        applicationId = "com.example.smartprofilemanagement"
//        minSdk = 25
//        targetSdk = 34
//        versionCode = 1
//        versionName = "1.0"
//
//        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
//        vectorDrawables {
//            useSupportLibrary = true
//        }
//    }
//
//    buildTypes {
//        release {
//            isMinifyEnabled = false
//            proguardFiles(
//                getDefaultProguardFile("proguard-android-optimize.txt"),
//                "proguard-rules.pro"
//            )
//        }
//    }
//    compileOptions {
//        sourceCompatibility = JavaVersion.VERSION_1_8
//        targetCompatibility = JavaVersion.VERSION_1_8
//    }
//    kotlinOptions {
//        jvmTarget = "1.8"
//    }
//    buildFeatures {
//        compose = true
//    }
//    composeOptions {
//        kotlinCompilerExtensionVersion = "1.5.1"
//    }
//    packaging {
//        resources {
//            excludes += "/META-INF/{AL2.0,LGPL2.1}"
//        }
//    }
//}
//
//dependencies {
//
////    implementation("androidx.core:core-ktx:1.12.0")
////    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
////    implementation("androidx.activity:activity-compose:1.8.1")
////    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
////    implementation("androidx.compose.ui:ui")
////    implementation("androidx.compose.ui:ui-graphics")
////    implementation("androidx.compose.ui:ui-tooling-preview")
////    implementation("androidx.compose.material3:material3")
////    implementation("androidx.room:room-common:2.6.1")
////    testImplementation("junit:junit:4.13.2")
////    androidTestImplementation("androidx.test.ext:junit:1.1.5")
////    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
////    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
////    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
////    debugImplementation("androidx.compose.ui:ui-tooling")
////    debugImplementation("androidx.compose.ui:ui-test-manifest")
//
//
///////////////////////////// Hamza Dependencies   //////////////////////////
//    implementation("androidx.core:core-ktx:1.12.0")
//    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
//    implementation("androidx.activity:activity-compose:1.8.1")
//    implementation(platform("androidx.compose:compose-bom:2023.10.01"))
//    implementation("androidx.compose.ui:ui:1.5.4")
//    implementation("androidx.compose.ui:ui-graphics")
//    implementation("androidx.compose.ui:ui-tooling-preview")
//    implementation("androidx.compose.material3:material3-android:1.2.0-alpha12")
//    implementation("androidx.navigation:navigation-runtime-ktx:2.7.5")
//    implementation("androidx.navigation:navigation-compose:2.7.5")
//    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.2")
//    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
//    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
//    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")
//    implementation("androidx.room:room-common:2.6.1")
//    implementation("androidx.compose.runtime:runtime:1.5.4")
//    implementation("androidx.compose.runtime:runtime-livedata:1.5.4")
//    implementation("androidx.compose.foundation:foundation:1.5.4")
//    implementation("androidx.room:room-runtime:2.6.1")
//    implementation("androidx.wear.compose:compose-material:1.2.1")
//    implementation("androidx.compose.material3:material3-window-size-class:1.1.2")
//    implementation("androidx.compose.material3:material3-adaptive-navigation-suite-android:1.0.0-alpha01")
//    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    //    implementation("com.google.android.ads:mediation-test-suite:3.0.0")
//    implementation("com.google.android.libraries.mapsplatform.transportation:transportation-consumer:2.0.0")
//    annotationProcessor("androidx.room:room-compiler:2.6.1")
//    testImplementation("junit:junit:4.13.2")
//    androidTestImplementation("androidx.test.ext:junit:1.1.5")
//    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
//    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
//    debugImplementation("androidx.compose.ui:ui-tooling")
//    debugImplementation("androidx.compose.ui:ui-test-manifest")
//
//
//
//    // Sir Hassan Dependencies
//
//    implementation("androidx.core:core-ktx:1.9.0")
//    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
//    implementation("androidx.activity:activity-compose:1.7.2")
//    implementation(platform("androidx.compose:compose-bom:2023.10.00"))
//    implementation("androidx.compose.ui:ui")
//    implementation("androidx.compose.ui:ui-graphics")
//    implementation("androidx.compose.ui:ui-tooling-preview")
//    implementation("androidx.compose.material3:material3")
//    testImplementation("junit:junit:4.13.2")
//    androidTestImplementation("androidx.test.ext:junit:1.1.5")
//    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
//    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
//    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
//    debugImplementation("androidx.compose.ui:ui-tooling")
//    debugImplementation("androidx.compose.ui:ui-test-manifest")
//
//    // Room Database
//    val room_version = "2.5.2"
//    implementation("androidx.room:room-runtime:$room_version")
//    // optional - Kotlin Extensions and Coroutines support for Room
//    implementation("androidx.room:room-ktx:$room_version")
//    annotationProcessor("androidx.room:room-compiler:$room_version")
//    implementation("androidx.room:room-rxjava2:$room_version")  // optional - RxJava2 support for Room
//    implementation("androidx.room:room-rxjava3:$room_version")  // optional - RxJava3 support for Room
//    implementation("androidx.room:room-guava:$room_version")  // optional - Guava support for Room, including Optional and ListenableFuture
//    implementation("androidx.room:room-paging:$room_version") // optional - Paging 3 Integration
//    //    testImplementation("androidx.room:room-testing:$room_version") // optional - Test helpers
//
//    ksp("androidx.room:room-compiler:$room_version") // To use Kotlin Symbol Processing (KSP)
//
//    // Lifecycle components
//    val lifecycle_version = "2.6.2"
//    val arch_version = "2.2.0"
//
//    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version") // ViewModel
//    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycle_version") // ViewModel utilities for Compose
//    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")  // LiveData
//    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version")  // Lifecycles only (without ViewModel or LiveData)
//    implementation("androidx.lifecycle:lifecycle-runtime-compose:$lifecycle_version")  // Lifecycle utilities for Compose
//    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycle_version") // Saved state module for ViewModel
//    ksp("androidx.lifecycle:lifecycle-compiler:$lifecycle_version") // Annotation processor
//
//    val nav_version = "2.7.3"
//
//    implementation("androidx.navigation:navigation-runtime-ktx:$nav_version")
//    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")
//    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
//    implementation("androidx.navigation:navigation-compose:$nav_version")
//
//
////    implementation("androidx.lifecycle:lifecycle-common-java8:$lifecycle_version") // alternately - if using Java8, use the following instead of lifecycle-compiler
////    implementation("androidx.lifecycle:lifecycle-service:$lifecycle_version")  // optional - helpers for implementing LifecycleOwner in a Service
////    implementation("androidx.lifecycle:lifecycle-process:$lifecycle_version")  // optional - ProcessLifecycleOwner provides a lifecycle for the whole application process
////    implementation("androidx.lifecycle:lifecycle-reactivestreams-ktx:$lifecycle_version") // optional - ReactiveStreams support for LiveData
////    testImplementation("androidx.arch.core:core-testing:$arch_version") // optional - Test helpers for LiveData
////    testImplementation ("androidx.lifecycle:lifecycle-runtime-testing:$lifecycle_version")  // optional - Test helpers for Lifecycle runtime
//
//}







