import dependencies.addRouterModule

plugins {
    plugins.`android-feature-library`
}

android {
    namespace = "com.example.repolist"
}

dependencies {
    addRouterModule()
}
