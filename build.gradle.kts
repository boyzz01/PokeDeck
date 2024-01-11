buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.4.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.47")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven { url = uri("https://maven.google.com") }
        maven { url = uri("https://jitpack.io") }
        maven { url = uri("https://maven.apptimize.com/artifactory/repo") }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
