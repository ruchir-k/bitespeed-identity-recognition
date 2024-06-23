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

dependencies {
    implementation("io.ktor:ktor-server-core:2.3.11")
    implementation("io.ktor:ktor-server-netty:2.3.11")
    implementation("io.ktor:ktor-server-content-negotiation:2.3.7")
    implementation ("io.ktor:ktor-serialization:2.3.7")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.7")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
    implementation("com.google.dagger:dagger:2.50")
    annotationProcessor("com.google.dagger:dagger-compiler:2.50")
    kapt("com.google.dagger:dagger-compiler:2.50")
    implementation ("com.zaxxer:HikariCP:5.0.0")
    implementation ("org.jetbrains.exposed:exposed-core:0.41.1")
    implementation( "org.jetbrains.exposed:exposed-dao:0.41.1")
    implementation ("org.jetbrains.exposed:exposed-jdbc:0.41.1")
    implementation("org.postgresql:postgresql:42.2.6")

    implementation(project(":core-api-models"))
    implementation(project(":core-api-service"))
    implementation(project(":core-domain"))
    implementation(project(":core-data-psql"))
}

application{
    mainClass.set("bitespeed.ir.ktor.server.appserver.MainApplication.kt")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}