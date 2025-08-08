plugins {
    id("java")
}

group = "taller"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("com.google.code.gson:gson:2.13.1")
    implementation("org.projectlombok:lombok:0.11.0")
    implementation("org.apache.logging.log4j:log4j-core:3.0.0-beta3")
    implementation("org.apache.commons:commons-collections4:4.5.0")
}

tasks.test {
    useJUnitPlatform()
}