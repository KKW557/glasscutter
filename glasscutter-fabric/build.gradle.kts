plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.fabric.loom)
}

dependencies {
    minecraft(libs.minecraft)
    implementation(libs.fabric.loader)
    implementation(libs.fabric.kotlin)
    implementation(libs.fabric.api)
    implementation(project(":glasscutter-common"))
}

tasks.processResources {
    from(project(":glasscutter-common").fileTree("src/main/resources"))

    filteringCharset = "UTF-8"

    inputs.property("version", project.version)
    inputs.property("minecraft", libs.versions.minecraft.get())
    inputs.property("loader", libs.versions.fabric.loader.get())

    filesMatching("fabric.mod.json") {
        expand(
            "version" to version,
            "minecraft" to libs.versions.minecraft.get(),
            "loader" to libs.versions.fabric.loader.get()
        )
    }
}

tasks.jar {
    from(project(":glasscutter-common").sourceSets.main.get().output)
}

tasks.sourcesJar {
    from(project(":glasscutter-common").sourceSets.main.get().allSource)
}