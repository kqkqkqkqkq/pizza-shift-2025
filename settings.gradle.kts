pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "shift"
include(":app")
include(":features:pizza-main:ui")
include(":features:pizza-main:ui-logic")
include(":ui-kit")
include(":pizza-core:pizza-data")
include(":pizza-core:pizza-api")
include(":pizza-core:pizza-database")
include(":utils")
