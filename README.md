# Space Shooter Game

A simple 2D arcade space shooter built with **libGDX**. Control the player ship, shoot enemies, and chase the high score. The game includes a start screen, restart flow, and a high-score popup.


## How to Play

- **Goal:** Survive as long as you can and score points by destroying enemy ships.
- Avoid collisions and keep firing to clear waves of enemies.


## Features

- Player (green), enemies (red), and bullets (blue)
- Circle bullets and hit detection
- Start screen and game-over screen
- High-score tracking and popup

## Controls

- Move: Arrow keys
- Shoot: Space
- Start/Restart: Enter (or Space)

> Note: If you use **Space** to start from the start screen, the same key is also used to shoot during gameplay.

## Requirements

- JDK 8+ installed

## Run the Game (Desktop)

Windows:

```
gradlew.bat lwjgl3:run
```

macOS/Linux:

```
./gradlew lwjgl3:run
```

## Build a Runnable Jar

```
./gradlew lwjgl3:jar
```

The jar will be in `lwjgl3/build/libs`.

## Troubleshooting

- macOS/Linux: if you get `permission denied` running `./gradlew`, run:

  ```
  chmod +x gradlew
  ```

- Ensure `JAVA_HOME` points to a JDK (not a JRE).

## Project Structure

- `core`: game logic shared by all platforms
- `lwjgl3`: desktop launcher (LWJGL3)
