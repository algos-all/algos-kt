import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.gradle.api.tasks.testing.logging.TestExceptionFormat

val versionJUnit = "5.9.2"
val versionStrikt = "0.34.0"

plugins {
    java
    kotlin("jvm") version "1.8.20"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("io.strikt:strikt-core:$versionStrikt")
    testImplementation(platform("org.junit:junit-bom:$versionJUnit"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
    testLogging {
        // Show the entire assertion, not just that it failed:
        exceptionFormat = TestExceptionFormat.FULL
        // Show only the problematic tests, skip the "passed" ones
        events("skipped", "failed")
    }

    addTestListener(CustomTestListener())
}

class CustomTestListener : TestListener {
    override fun beforeSuite(suite: TestDescriptor?) {
    }

    override fun afterSuite(suite: TestDescriptor?, result: TestResult?) {
        logger.trace("Enter afterSuite(suite, result)")

        if (suite == null) {
            logger.error("TestDescriptor is null, this is a bug!")
            return
        }
        if (result == null) {
            logger.error("TestResult is null, this is a bug!")
            return
        }

        // This happens once at the end, when there is no parent test suite
        if (suite.parent == null) {
            val message = "  Total: ${result.testCount}"
            val success = "Success: ${result.successfulTestCount}"
            val skipped = "Skipped: ${result.skippedTestCount}"
            val failure = "Failure: ${result.failedTestCount}"
            val verdict = "Verdict: ${result.resultType}"

            logger.warn("$message\n$success\n$skipped\n$failure\n$verdict")
            return
        }

        logger.trace("Leave afterSuite(suite, result) (ok)")
    }

    override fun beforeTest(suite: TestDescriptor?) {
    }

    override fun afterTest(suite: TestDescriptor?, result: TestResult?) {
    }
}
