plugins {
    java
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.dependency.management)
}

group = "jp.co.yui.semba"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

extra["springCloudVersion"] = "2023.0.3"

// TODO: Version Catalog
val logbackEncoderVersion = "8.0"
val logbookVersion = "3.9.0"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.cloud:spring-cloud-starter-circuitbreaker-resilience4j")
    implementation("net.logstash.logback:logstash-logback-encoder:${logbackEncoderVersion}")
    implementation("org.zalando:logbook-spring-boot-starter:${logbookVersion}")
    compileOnly("org.projectlombok:lombok")
    runtimeOnly("com.h2database:h2")
    runtimeOnly("org.postgresql:postgresql")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

// Git ハッシュを取得
val gitCommit: String by lazy {
    val process = ProcessBuilder("git", "rev-parse", "--short", "HEAD")
        .redirectErrorStream(true)
        .start()
    process.inputStream.bufferedReader().use { it.readText().trim() }
}

tasks.named<Jar>("bootJar") {
    manifest {
        attributes(
            "Git-Commit" to gitCommit,
            "App-Version" to project.version
        )
    }
}

tasks.named<ProcessResources>("processResources") {
    filesMatching("**/application.properties") {
        expand("gitCommit" to gitCommit, "appVersion" to project.version)
    }
}
