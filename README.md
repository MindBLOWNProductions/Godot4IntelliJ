# Godot Project Starter (IntelliJ IDEA plugin)

* **File | New | Project → Godot** – scaffolds a Godot 4 project (`project.godot`, `main.tscn`, `main.gd`, `icon.svg`,
  `.gitignore`, `.gitattributes`), lets you pick the renderer, and optionally opens the Godot editor.
* **GDScript syntax highlighting** – highlights GDScript keywords, built-in types, strings, numbers, comments, and operators in `.gd` files.
* **Auto-download** – if Godot isn't found (settings → `$GODOT` → `PATH` → plugin-managed → common install dirs), the wizard offers to
  download the official build from GitHub Releases, verifies it against `SHA512-SUMS.txt`, and installs it to
  `~/.godot-idea-plugin/engines/<version>/`.
* **Tools | Godot** – *Open Project in Godot Editor*, *Run Godot Project* (output shown in a Run window), *Download Godot…*
* **Settings | Tools | Godot** – choose/detect/download the engine.

## Build & run

```
gradle wrapper --gradle-version 8.13   # once, generates ./gradlew
./gradlew runIde                       # sandbox IDE with the plugin
./gradlew buildPlugin                  # zip in build/distributions/
```
Requires JDK 21. Edit `gradle.properties` to change the target IDE (`platformType`, `platformVersion`).
Install the zip via Settings | Plugins | ⚙ | Install Plugin from Disk.
