plugins {
    application
    id("com.diffplug.spotless") version "6.25.0"
    id("com.github.ben-manes.versions") version "0.54.0"
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

application {
    mainClass.set("hexlet.code.App")
}

group = "org.example"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
}

spotless {
    java {
        importOrder()
        removeUnusedImports()
        googleJavaFormat().aosp()
        formatAnnotations()
    }
}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}