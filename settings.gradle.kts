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
include(":features:cart:ui")
include(":features:cart:ui-logic")
include(":features:orders:ui")
include(":features:orders:ui-logic")
include(":features:profile:ui")
include(":features:profile:ui-logic")
include(":features:pizza-detail:ui")
include(":features:pizza-detail:ui-logic")

include(":ui-kit")
include(":ui-utils")
include(":pizza-data")
include(":pizza-api")
include(":pizza-database")
