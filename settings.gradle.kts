pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
        maven("https://maven.sumsub.com/repository/maven-public/")
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "AtomTest"
include(":app")
include(":uikit")
include(":feature_choose_city_api")
include(":feature_choose_city_impl")
include(":feature_charger_list_api")
include(":feature_charger_list_impl")
include(":core")
include(":data")
