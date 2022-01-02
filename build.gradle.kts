import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm") version "1.6.10"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("io.strikt:strikt-core:0.33.0")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}