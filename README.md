# Space Shooter Game

A simple 2D space shooter built with libGDX. Control the player ship, shoot enemies, and chase the high score. The game includes a start screen, restart flow, and a high-score popup.

## Features

- Player (green), enemies (red), and bullets (blue)
- Circle bullets and hit detection
- Start screen and game-over screen
- High-score tracking and popup

## Controls

- Move: Arrow keys
- Shoot: Space
- Start/Restart: Enter (or Space)

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

## Project Structure

- `core`: game logic shared by all platforms
- `lwjgl3`: desktop launcher (LWJGL3)
