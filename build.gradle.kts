val minecraft = libs.versions.minecraft.get()

subprojects {
    project.version = "${project.version}+${minecraft}"

    plugins.withId("java") {
        extensions.configure<JavaPluginExtension> {
            toolchain.languageVersion = JavaLanguageVersion.of(21)
            withSourcesJar()
        }

        tasks.withType<Jar>().configureEach {
            from(rootProject.file("LICENSE")) {
                into("META-INF")
            }
        }
    }
}