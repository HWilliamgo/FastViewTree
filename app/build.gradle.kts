plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
}

android {
    compileSdkVersion(29)
    buildToolsVersion("29.0.2")
    defaultConfig {
        applicationId = "com.hwilliamgo.fastviewtree"
        minSdkVersion(15)
        targetSdkVersion(29)
        versionCode = Version.versionCode
        versionName = Version.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        val release by getting {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(fileTree("libs") { include("*.java") })
    val kotlin_version: String by rootProject.extra
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version")
    implementation("androidx.appcompat:appcompat:1.0.2")
    implementation("androidx.core:core-ktx:1.0.2")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    testImplementation("junit:junit:4.12")
    androidTestImplementation("androidx.test.ext:junit:1.1.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.1.1")

//    implementation(project(":fastviewtree"))
    implementation(project(":purejava"))
    implementation(("com.hwilliamgo:fastviewtree:1.0.6")) {
        isChanging = true
    }
}

configurations.all {
    resolutionStrategy.cacheChangingModulesFor(0, "seconds")
}
