plugins {
    kotlin("jvm")
    id("org.jetbrains.kotlin.kapt") version "1.9.22"
}

group = "core.domain"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.dagger:dagger:2.50")
    annotationProcessor("com.google.dagger:dagger-compiler:2.50")
    kapt("com.google.dagger:dagger-compiler:2.50")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}