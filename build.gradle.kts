import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.5.5" apply false
    id("io.spring.dependency-management") version "1.0.11.RELEASE" apply false
    kotlin("jvm") version "1.5.31" apply false
    kotlin("plugin.spring") version "1.5.31" apply false
}

allprojects {
    group = "io.uvera"
    version = "0.1.0"
    tasks.withType<JavaCompile> {
        sourceCompatibility = "11"
    }
    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
        }
    }
}

subprojects {
    repositories {
        mavenCentral()
    }

    apply {
        plugin("io.spring.dependency-management")
        plugin("maven-publish")
    }
}
