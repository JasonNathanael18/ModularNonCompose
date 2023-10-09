import dependencies.addRouterModule

plugins {
    plugins.`android-feature-library`
}

android {
    namespace = "com.example.profile"
}

dependencies {
    addRouterModule()
}
