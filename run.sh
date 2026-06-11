#!/usr/bin/env bash

mod_id=$(grep "mod_id" gradle.properties | awk -F "=" '{print $2}')
mod_version=$(grep "mod_version" gradle.properties | awk -F "=" '{print $2}')
minecraft_version=$(grep "minecraft_version" gradle.properties | awk -F "=" '{print $2}')

./gradlew build && cp "./build/libs/$mod_id-$mod_version+$minecraft_version.jar" ~/.local/share/FreesmLauncher/instances/26.1.2/minecraft/mods
