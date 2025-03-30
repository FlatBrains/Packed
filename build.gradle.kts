
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
    id("org.jetbrains.kotlin.plugin.compose")
    kotlin("plugin.serialization") version "1.8.0"
    

}

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


/*kotlin {
    jvmToolchain(21)
    
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}*/
compose.desktop {
    
    application {
        mainClass = "MainKt"
        
        nativeDistributions {
            targetFormats(
                TargetFormat.Exe, TargetFormat.Msi, //windows
                TargetFormat.AppImage, TargetFormat.Deb, TargetFormat.Rpm, //linux
            )
            packageName = "Packed"
            packageVersion = "1.0.0"
            
          windows {
                iconFile.set(project.file("src/main/resources/images/packed.ico"))
            }
            
            
/*            buildTypes.release.proguard  {
                isEnabled = false
            }*//*
            
            
            //modules = arrayListOf("java.base", "java.desktop")
            javaHome = "C:\\Program Files\\Java\\jdk-21.0.6"
            
            */
            
            
        }
    }
}