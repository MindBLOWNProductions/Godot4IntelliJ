plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "2.1.20"
    id("org.jetbrains.intellij.platform") version "2.5.0"
}

group = providers.gradleProperty("pluginGroup").get()
version = providers.gradleProperty("pluginVersion").get()

repositories {
    mavenCentral()
    intellijPlatform {
        defaultRepositories()
    }

    tasks.named("instrumentCode") {
        doFirst {
            // Java 21 uses the JRT filesystem; Ant's legacy runtime scan expects a nonexistent JDK\Packages folder on Windows.
            project.ant.withGroovyBuilder {
                "property"(
                    "name" to "javac2.instrumentation.includeJavaRuntime",
                    "value" to "false",
                )
            }
        }
    }
}

dependencies {
    intellijPlatform {
        create(providers.gradleProperty("platformType"), providers.gradleProperty("platformVersion"))
    }
}

kotlin {
    jvmToolchain(21)
}

intellijPlatform {
    buildSearchableOptions = false
    pluginConfiguration {
        ideaVersion {
            sinceBuild = "242"
            untilBuild = provider { null }
        }
    }
}
