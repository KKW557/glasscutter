subprojects {
    plugins.withId("java") {
        extensions.configure<BasePluginExtension> {
            archivesName.set("${project.name}+${libs.versions.minecraft.get()}")
        }

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