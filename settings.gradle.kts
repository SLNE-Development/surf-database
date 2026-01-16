rootProject.name = "surf-database"

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://repo.slne.dev/repository/maven-public/") { name = "maven-public" }
    }
    plugins {
        id("dev.slne.surf.surf-api-gradle-plugin") version "1.21.11+"
        id("dev.slne.surf.surfapi.gradle.core") version "1.21.11+"
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.9.0"
}
