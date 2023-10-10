pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        mavenLocal()
        google()
        maven("https://jitpack.io")
        maven("https://oss.jfrog.org/libs-snapshot")

    }

    gradle.projectsLoaded {
        plugins{
            plugins {
                id ("com.android.application") version(extra.properties["androidGradlePluginVersion"].toString())
                id ("com.android.library") version(extra.properties["androidGradlePluginVersion"].toString())
                id ("org.jetbrains.kotlin.android") version(extra.properties["kotlinVersion"].toString())
                id ("org.jetbrains.kotlin.jvm") version(extra.properties["kotlinVersion"].toString())
                id ("com.google.dagger.hilt.android") version(extra.properties["hiltVersion"].toString())
                id ("androidx.navigation.safeargs") version(extra.properties["navigationSafeArgsVersion"].toString())
            }
        }
    }
}


dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        gradlePluginPortal()
        mavenCentral()
        mavenLocal()
        google()
        maven("https://jitpack.io")
        maven("https://oss.jfrog.org/libs-snapshot")
    }
}

rootProject.name = "ModularNonCompose"
include(":app")
include(":di")
include(":domain")
include(":model:entity")
include(":model:apiresponse")
include(":data")
include(":feature_profile")
include(":feature_repolist")
include(":router")
include(":uicomponent")
