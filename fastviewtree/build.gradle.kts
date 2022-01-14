plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
}
android {
    compileSdkVersion(29)
    buildToolsVersion("29.0.2")


    defaultConfig {
        minSdkVersion(15)
        targetSdkVersion(29)
        val version_code :Int by extra
        val version_name:String by extra
        versionCode =version_code
        versionName = version_name
        testInstrumentationRunner="androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    testImplementation("junit:junit:4.12")
    androidTestImplementation("androidx.test.ext:junit:1.1.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.1.1")
}

//apply(from: "./gradleScript/bintrayUpload.gradle")
