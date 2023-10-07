import dependencies.addEntityModule

plugins {
    plugins.`android-core-library`
}
android {
    namespace = "com.example.domain"
}
dependencies {
    addEntityModule(configurationName = "api")
}