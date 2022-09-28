plugins {
    id("dependencies-updater")
    alias(libs.plugins.appPlugin) apply false
    alias(libs.plugins.androidPlugin) apply false
    alias(libs.plugins.libraryPlugin) apply false
    alias(libs.plugins.kaptPlugin) apply false
    alias(libs.plugins.detektPlugin) apply false
    alias(libs.plugins.multiplatformPlugin) apply false
    alias(libs.plugins.serializationPlugin) apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

apply(from = "${config.GradleExtraArgs.getGradleSupportFolder(project)}linters.gradle")
