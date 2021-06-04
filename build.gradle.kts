import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.5.0"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	// Kotlin
	kotlin("jvm") version "1.5.10"
	kotlin("plugin.spring") version "1.5.10"
	id("org.jetbrains.kotlin.plugin.jpa") version "1.5.10"
	// War
	war
}

tasks.bootWar {
	archiveBaseName.set("dh_server")
}

// group = "com.com.madrat"
// version = "0.0.1-SNAPSHOT"

java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	mavenCentral()
}

dependencies {
	// Spring
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	providedRuntime("org.springframework.boot:spring-boot-starter-tomcat")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	// Kotlin
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	// Jackson
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	// MySQL
	runtimeOnly("mysql:mysql-connector-java")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
