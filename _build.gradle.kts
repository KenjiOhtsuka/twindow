import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("java")
    id("org.jetbrains.intellij") version "0.3.12"
    id("org.jetbrains.kotlin.jvm") version "1.3.0"
}

apply {
    plugin("org.jetbrains.intellij")
}

group = "com.improve_future"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    mavenCentral()
}

dependencies {
    compile("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testCompile("junit:junit:4.12")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = listOf("-Xjsr305=strict")
    }
}

intellij {
    version = "2018.2.4"
}

patchPluginXml {
    changeNotes = """
      Add change notes here.<br>
      <em>most HTML tags may be used</em>""".trimIndent()
}