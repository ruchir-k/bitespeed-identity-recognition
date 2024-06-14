plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.7.0"
}
rootProject.name = "IdentityReconciliation"

include(":core-api-models")
project(":core-api-models").projectDir = file("core/api/models")

include(":core-api-service")
project(":core-api-service").projectDir = file("core/api/service")

include(":core-data-psql")
project(":core-data-psql").projectDir = file("core/data/psql")

include(":core-domain")
project(":core-domain").projectDir = file("core/domain")

include(":ktor-server")
project(":ktor-server").projectDir = file("ktor/server")

