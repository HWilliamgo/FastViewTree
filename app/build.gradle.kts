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
        val version_code :Int by extra
        val version_name:String by extra
        versionCode = version_code
        versionName = version_name
        testInstrumentationRunner="androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        val release by getting{
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(fileTree("libs") { include("*.java") })
    val kotlin_version: String by extra
    implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version")
    implementation("androidx.appcompat:appcompat:1.0.2")
    implementation("androidx.core:core-ktx:1.0.2")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    testImplementation("junit:junit:4.12")
    androidTestImplementation("androidx.test.ext:junit:1.1.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.1.1")

    implementation(project(":fastviewtree"))
    implementation(project(":purejava"))
//    implementation(("com.hwilliamgo:fastviewtree:1.0.4"))
}
