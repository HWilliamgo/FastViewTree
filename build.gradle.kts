// Top-level(build file where you can add configuration options common to all sub-projects/modules.)

buildscript {

    repositories {
        extra["kotlin_version"] = "1.3.71"
        google()
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
        mavenCentral()

        // 以下二者选其一，gitee速度较快，github可能被墙
//        maven("https://github.com/HWilliamgo/maven-repository/raw/SNAPSHOT")
        maven("https://gitee.com/HWilliamgo/maven-repository/raw/SNAPSHOT")

    }
}

extra["version_name"] = "1.0.5"
extra["version_code"] = 5

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}
