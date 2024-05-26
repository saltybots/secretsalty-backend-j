import org.jooq.meta.jaxb.Logging

plugins {
    java
    id("org.springframework.boot") version "3.2.1"
    id("nu.studer.jooq") version "9.0"
    id("com.google.cloud.tools.jib") version "3.4.0"
    id("io.spring.dependency-management") version "1.1.5"
    id("org.openapi.generator") version "7.5.0"
    id("com.diffplug.spotless") version "6.25.0"
    id("org.springdoc.openapi-gradle-plugin") version "1.8.0"
}

group = "com.secretsalty"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
    mavenCentral()
}

val postgresqlVersion = "42.7.3"
val lombokVersion = "1.18.32"

dependencies {
    // spring starter stuff
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-jooq")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.5.0")

    // oauth / firebase
    implementation("com.google.firebase:firebase-admin:9.2.0")
    implementation("org.springframework.security:spring-security-oauth2-jose")
    implementation("org.springframework.security:spring-security-oauth2-resource-server")

    // misc
    implementation("org.slf4j:slf4j-api")
    implementation("com.fasterxml.jackson.core:jackson-core")

    // db
    implementation("org.flywaydb:flyway-core")
    implementation("org.postgresql:postgresql:$postgresqlVersion")
    jooqGenerator("org.postgresql:postgresql:$postgresqlVersion")

    // lombok
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    testCompileOnly("org.projectlombok:lombok")
    testAnnotationProcessor("org.projectlombok:lombok")

    // tests
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.mockito:mockito-core")
    testImplementation("junit:junit")
    testImplementation("com.tngtech.archunit:archunit-junit5:1.3.0")
    testImplementation("org.instancio:instancio-junit:4.5.1")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

spotless {
    java {
        googleJavaFormat()
    }
}

/*
    JOOQ setup
*/
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
                        isImmutablePojos = false
                        isRecords = true
                        isFluentSetters = true
                    }
                    target.apply {
                        packageName = "data.jooq"
                        directory = "src/main/java/com/secretsalty/secretsalty/data/jooq"
                    }
                }
            }
        }
    }
}

/*
    OpenAPI Generation
 */
rootProject.afterEvaluate {
    val forkedSpringBootRun = project.tasks.named("forkedSpringBootRun")
    forkedSpringBootRun.configure {
        doNotTrackState("See https://github.com/springdoc/springdoc-openapi-gradle-plugin/issues/102")
    }
    val generateOpenApiDocs = project.tasks.named("generateOpenApiDocs")
    generateOpenApiDocs.configure {
        doNotTrackState("See https://github.com/springdoc/springdoc-openapi-gradle-plugin/issues/102")
    }
}

openApi {
    outputDir.set(File("/build/docs"))
}

openApiGenerate {
    generatorName.set("typescript-angular")
    inputSpec.set("$rootDir/build/docs/openapi.json")
    // if it works it works (sorry)
    outputDir.set("$rootDir/../../secretsalty-frontend/src/app/core/openapi/")

    configOptions.set(
        mapOf(
            "typeScriptVersion" to "5.2.2",
            "useRxJS" to "true",
            "ngVersion" to "17.0.0",
            "supportsES6" to "true",
        )
    )
    typeMappings.set(
        mapOf(
            "DateTime" to "Date",
            "LocalDate" to "Date",
            "set" to "Array"
        )
    )
}
