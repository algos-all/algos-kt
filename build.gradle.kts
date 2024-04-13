import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    alias(libs.plugins.jvm)
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(libs.strikt.core) {
        because("Add fluent assertThat statements")
    }
    testImplementation(libs.junit.jupiter) {
        because("Use unit test framework")
    }
    testRuntimeOnly(libs.junit.platform.launcher) {
        because("Run unit test framework")
    }
}

tasks.withType<JavaCompile> {
    sourceCompatibility = "17"
    targetCompatibility = "17"
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
