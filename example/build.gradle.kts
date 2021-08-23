plugins {
    java
    kotlin("jvm") version "1.5.21"
}

version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":library"))
    implementation(kotlin("stdlib"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}