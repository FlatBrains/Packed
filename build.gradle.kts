
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
    id("org.jetbrains.kotlin.plugin.compose")
    kotlin("plugin.serialization") version "1.8.0"
    

}
description = "Easy to use editor for minecraft resource packs and more!"
group = "net.lambdagames"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}

dependencies {
    implementation(compose.desktop.currentOs)
    implementation(compose.components.resources)
    //implementation("org.jetbrains.compose.components:components-resources:1.8.0-beta01")
    
    implementation("org.jetbrains.skiko:skiko-awt:0.9.3")
    implementation("org.jetbrains.skiko:skiko-awt-runtime-windows-x64:0.9.3")
    
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.8.0")
    
    implementation("org.jetbrains.compose.components:components-splitpane-desktop:1.8.0-beta01")
    implementation("org.jetbrains.compose.ui:ui-unit:1.7.3")
    //implementation("androidx.compose.ui:ui-util:1.7.8")
    implementation("org.jetbrains.compose.ui:ui-util:1.7.3")
    
    implementation("org.jetbrains.compose.material:material-icons-extended:1.7.3")
    
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0")
    

    
    /* * FolderDialog * */
    implementation(platform("org.lwjgl:lwjgl-bom:3.3.6"))
    implementation("org.lwjgl:lwjgl")
    implementation("org.lwjgl:lwjgl-nfd")
    runtimeOnly("org.lwjgl:lwjgl::natives-windows")
    runtimeOnly("org.lwjgl:lwjgl-nfd::natives-windows")
    runtimeOnly("org.lwjgl:lwjgl::natives-macos")
    runtimeOnly("org.lwjgl:lwjgl-nfd::natives-macos")
    runtimeOnly("org.lwjgl:lwjgl::natives-linux")
    runtimeOnly("org.lwjgl:lwjgl-nfd::natives-linux")
    
}


compose.resources {
    publicResClass = true
    packageOfResClass = "packed"
    generateResClass = auto
}

compose.desktop {
    
    application {
        mainClass = "MainKt"
        
        nativeDistributions {
            targetFormats(
                TargetFormat.Msi, TargetFormat.Exe,
                TargetFormat.Deb, TargetFormat.Rpm, TargetFormat.AppImage,
                TargetFormat.Dmg, TargetFormat.Pkg
                )
            packageName = "Packed"
            packageVersion = "1.0.0"
            
            windows {
                iconFile.set(project.file("src/main/resources/images/packed.ico"))
                menuGroup = "Packed"
                dirChooser = true
                perUserInstall = true
                upgradeUuid = "26613439-95a1-45b4-b2d0-b6e064317dcd" // That is my minecraft uuid | "That is unironically based as hell and I fully support it." -Chat Fucking GPT
            }
        }
    }
}

// May your builds be many, and you merges few