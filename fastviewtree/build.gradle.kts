plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("maven-publish")
}
android {
    compileSdkVersion(29)
    buildToolsVersion("29.0.2")


    defaultConfig {
        minSdkVersion(15)
        targetSdkVersion(29)
        val version_code: Int by rootProject.extra
        val version_name: String by rootProject.extra
        versionCode = version_code
        versionName = version_name
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    testImplementation("junit:junit:4.12")
    androidTestImplementation("androidx.test.ext:junit:1.1.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.1.1")
}


java {

}
afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("ReleasePKG") {
                from(components["release"])
                groupId = "com.hwilliamgo"
                artifactId = "fastviewtree"
                version = "1.0.6-SNAPSHOT"
            }
        }
        repositories {
            maven {
                // change URLs to point to your repos, e.g. http://my.org/repo
                val releasesRepoUrl = uri(file("/Users/HWilliam/maven/maven-repository"))
                val snapshotsRepoUrl = uri(layout.buildDirectory.dir("repos/snapshots"))
                url = if (version.toString().endsWith("SNAPSHOT"))
                    snapshotsRepoUrl else releasesRepoUrl
            }
        }
    }
}

//tasks.javadoc {
//    if (JavaVersion.current().isJava9Compatible) {
//        (options as StandardJavadocDocletOptions).addBooleanOption("html5", true)
//    }
//}

