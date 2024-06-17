plugins {
    kotlin("jvm") version "1.9.22"
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.apache.spark:spark-sql_2.13:3.3.1") // Apache Spark 3.3.1 for Scala 2.13
    implementation("org.jetbrains.kotlinx.spark:kotlin-spark-api_3.3.1_2.13:1.2.3") // Spark Kotlin API 1.2.3 for Apache Spark 3.3.1 (and Scala 2.13)
    implementation("com.fasterxml.jackson.core:jackson-core:2.14.2") // Required for proper work by other dependencies
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}

tasks.shadowJar {
    isZip64 = true
}

kotlin {
    jvmToolchain(11)
}
