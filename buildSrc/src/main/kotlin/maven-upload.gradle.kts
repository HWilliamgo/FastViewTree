/**
 * @date: 2022/1/21
 * @author: HWilliamgo
 * @description:
 */
plugins {
    id("maven-publish")
}

interface MavenUploadExtension {
    val srcDirs: Property<String>
}

val mExtension = project.extensions.create("mavenUpload", MavenUploadExtension::class.java)

//tasks.register<Jar>("androidSourcesJar") {
//    archiveClassifier.set("sources")
//    from(mExtension.srcDirs.get())
//}
tasks.register("HelloC"){
    doLast{
        println(mExtension.srcDirs.get())
    }
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("ReleasePKG") {
                from(components["release"])
                groupId = Version.groupId
                artifactId = Version.artifactId
                version = Version.versionName
//                artifact(tasks.findByName("androidSourcesJar"))
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