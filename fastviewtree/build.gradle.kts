plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("maven-publish")
}

var srcDirs: Set<File>? = null

android {
    compileSdkVersion(29)
    buildToolsVersion("29.0.2")


    defaultConfig {
        minSdkVersion(15)
        targetSdkVersion(29)
        versionCode = Version.versionCode
        versionName = Version.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        val release by getting {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    sourceSets {
        getByName("main") {
            srcDirs = java.srcDirs
        }
    }
}

dependencies {
    implementation(fileTree("libs") { include("*.java") })
    testImplementation("junit:junit:4.12")
    androidTestImplementation("androidx.test.ext:junit:1.1.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.1.1")
}

tasks.register<Jar>("androidSourcesJar") {
    archiveClassifier.set("sources")
    from(srcDirs)
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("ReleasePKG") {
                from(components["release"])
                groupId = Version.groupId
                artifactId = Version.artifactId
                version = Version.versionName
                artifact(tasks.findByName("androidSourcesJar"))
            }
        }
        repositories {
            maven {
                val snapshotsRepoUrl = uri(layout.buildDirectory.dir("repos/snapshots"))
                val releasesRepoUrl = uri(file("/Users/HWilliam/maven/maven-repository"))
                url = if (Version.versionName.endsWith("SNAPSHOT"))
                    snapshotsRepoUrl else releasesRepoUrl
            }
        }
    }
}
