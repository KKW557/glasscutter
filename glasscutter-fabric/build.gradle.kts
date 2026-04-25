plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.fabric.loom)
}

dependencies {
    minecraft(libs.minecraft)
    mappings(loom.officialMojangMappings())
    modImplementation(libs.fabric.loader)
    modImplementation(libs.fabric.kotlin)
    modImplementation(libs.fabric.api)
    implementation(project(":glasscutter-common"))
    include(project(":glasscutter-common"))
}

tasks.processResources {
    filteringCharset = "UTF-8"

    inputs.property("version", project.version)
    inputs.property("minecraft", libs.versions.minecraft.get())
    inputs.property("fabricloader", libs.versions.fabric.loader.get())

    filesMatching("fabric.mod.json") {
        expand(
            "version" to version,
            "minecraft" to libs.versions.minecraft.get(),
            "fabricloader" to libs.versions.fabric.loader.get()
        )
    }
}