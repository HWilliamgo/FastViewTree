// Top-level(build file where you can add configuration options common to all sub-projects/modules.)

buildscript {

    repositories {
        extra["kotlin_version"] = "1.3.71"
        google()
        jcenter()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.6.0")
        val kotlin_version: String by project.extra
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
        // NOTE: Do(not place your application dependencies here; they belong)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
}

extra["version_name"] = "1.0.5"
extra["version_code"] = 5

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}
