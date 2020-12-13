plugins {
    `kotlin-dsl`
    java
    id("java-gradle-plugin")
}

configure<GradlePluginDevelopmentExtension> {
    plugins.apply {
        create("android-config") {
            id = "android-config"
            implementationClass = "plugins.AndroidConfigPlugin"
        }
        create("kotlin-config") {
            id = "kotlin-config"
            implementationClass = "plugins.KotlinConfigPlugin"
        }
        create("appcenter-config") {
            id = "appcenter-config"
            implementationClass = "plugins.AppCenterConfigPlugin"
        }
        create("ktlint-config") {
            id = "ktlint-config"
            implementationClass = "plugins.KtlintConfigPlugin"
        }
    }
}

repositories {
    mavenCentral()
    maven("https://plugins.gradle.org/m2/")
    google()
    jcenter()
}

dependencies {
    implementation("com.android.tools.build:gradle:3.6.2")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.71")
    implementation("gradle.plugin.com.betomorrow.gradle:appcenter-plugin:1.2.1")
    implementation("org.eclipse.jgit:org.eclipse.jgit.pgm:5.3.1.201904271842-r")
    implementation("org.jlleitschuh.gradle:ktlint-gradle:9.0.0")
}
