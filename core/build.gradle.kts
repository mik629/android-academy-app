plugins {
    alias(libs.plugins.multiplatformPlugin)
    alias(libs.plugins.serializationPlugin)
    alias(libs.plugins.libraryPlugin)
}

kotlin {
    android()

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64() // sure all ios dependencies support this target
    ).forEach {
        it.binaries.framework {
            baseName = "core"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                // Serialization
                implementation(libs.serialization)

                // Concurrency
                implementation(libs.coroutines)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(libs.coroutinesAndroid)
            }
        }
    }
}

android {
    compileSdk = io.github.androidacademyglobal.config.ApplicationConfig.androidCompileSdk
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = io.github.androidacademyglobal.config.ApplicationConfig.androidMinSdk
        targetSdk = io.github.androidacademyglobal.config.ApplicationConfig.androidTargetSdk
    }
}
