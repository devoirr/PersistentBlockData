plugins {
    kotlin("jvm") version "2.2.10"
}

group = "dev.devoirr"
version = "1.0.0"

repositories {
    mavenCentral()
    maven("https://repo.purpurmc.org/snapshots")
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:2.2.20")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")
    compileOnly("org.purpurmc.purpur", "purpur-api", "1.21.3-R0.1-SNAPSHOT")
}

tasks.jar {
    archiveFileName.set("PersistentBlockData.jar")
}

kotlin {
    jvmToolchain(21)
}