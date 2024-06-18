plugins {
    kotlin("jvm") version "1.9.23"
    id("io.ktor.plugin") version "2.3.7"
    kotlin("plugin.serialization") version "2.0.0"
    id("org.jetbrains.kotlin.kapt") version "1.9.22"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

application{
    mainClass.set("bitespeed.ir.ktor.server.appserver.MainApplication.kt")
}

dependencies {
    implementation("io.ktor:ktor-server-content-negotiation:2.3.7")
    implementation ("io.ktor:ktor-serialization:2.3.7")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.7")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
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