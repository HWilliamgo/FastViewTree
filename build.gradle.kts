// Top-level(build file where you can add configuration options common to all sub-projects/modules.)
buildscript {
    extra["kotlin_version"] = "1.3.71"
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.5.2")
        val kotlin_version: String by extra
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
        // NOTE: Do(not place your application dependencies here; they belong)
        classpath("com.jfrog.bintray.gradle:gradle-bintray-plugin:1.8.5")
        classpath("com.github.dcendents:android-maven-gradle-plugin:2.0")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

extra["versionName"]="1.0.5"
extra["versionCode"]=5

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}
