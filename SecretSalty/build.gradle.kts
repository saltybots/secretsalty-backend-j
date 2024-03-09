import org.jooq.meta.jaxb.Logging

plugins {
    java
    id("org.springframework.boot") version "3.2.1"
    id("nu.studer.jooq") version "9.0"
    id("com.google.cloud.tools.jib") version "3.4.0"
    id("io.spring.dependency-management") version "1.1.4"
}

group = "com.secretsalty"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
    mavenCentral()
}

val postgresqlVersion = "42.6.0"

dependencies {
    // spring starter stuff
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-jooq")

    // oauth / firebase
    implementation("com.google.firebase:firebase-admin:9.2.0")
    implementation("org.springframework.security:spring-security-oauth2-jose")
    implementation("org.springframework.security:spring-security-oauth2-resource-server:6.2.1")

    // misc
    implementation("org.slf4j:slf4j-api")
    implementation("org.projectlombok:lombok")
    implementation("com.fasterxml.jackson.core:jackson-core")

    // db
    implementation("org.flywaydb:flyway-core")
    implementation("org.postgresql:postgresql:$postgresqlVersion")
    jooqGenerator("org.postgresql:postgresql:$postgresqlVersion")

    // tests
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.mockito:mockito-core")
    testImplementation("junit:junit")
    testImplementation("org.instancio:instancio-junit:4.0.0")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

// jooq
jooq {
    version.set(dependencyManagement.importedProperties["jooq.version"])

    configurations {
        create("main") {
            generateSchemaSourceOnCompilation.set(false)

            jooqConfiguration.apply {
                logging = Logging.INFO

                jdbc.apply {
                    driver = "org.postgresql.Driver"
                    url = "jdbc:postgresql://localhost:5432/secretsalty"
                    user = "postgres"
                    password = "localpass1"
                }

                generator.apply {
                    name = "org.jooq.codegen.DefaultGenerator"
                    strategy.name = "org.jooq.codegen.DefaultGeneratorStrategy"
                    database.apply {
                        name = "org.jooq.meta.postgres.PostgresDatabase"
                        inputSchema = "public"
                        excludes = "flyway_schema_history"
                        isIncludeTriggers = false
                    }

                    generate.apply {
                        isDeprecated = false
                        isRecords = false
                        isImmutablePojos = false
                        isFluentSetters = false
                    }
                    target.apply {
                        packageName ="com.secretsalty.secretsalty"
                    }
                }
            }
        }
    }
}
