# MUD Adventure Game

## Overview
MUD Adventure Game is a simple text-based adventure game written in Java. The game allows a player to explore different locations, interact with NPCs, collect items, and encounter monsters. The goal is to navigate through the world and complete various challenges.

## Features
- Navigate through different areas (forest, dungeon, village, etc.).
- Interact with NPCs and receive quests or information.
- Collect and manage items in the inventory.
- Encounter and fight monsters.
- Open doors to access new locations.

## Project Structure
```
/mypackage
  ├── IGameEntity.java
  ├── Item.java
  ├── Merchant.java
  ├── Monster.java
  ├── Player.java
  ├── MUDController.java
  ├── MUDGame.java
  ├── ObjectItem.java
  ├── EntityInterface.java
```

## How to Run
1. **Compile the project**
   ```sh
   javac mypackage/*.java
   ```
2. **Run the game**
   ```sh
   java mypackage.GameLauncher
   ```

## Git Commands for Uploading
```sh
# Initialize a Git repository
git init

# Add all files to the repository
git add .

# Commit the files with a message
git commit -m "Initial commit - MUD Adventure Game"

# Create a new GitHub repository (if not created yet)
# Then link your local repo to GitHub

git branch -M main
git remote add origin https://github.com/your-username/mud-adventure.git

git push -u origin main
```
Replace `your-username` with your actual GitHub username.


- Add combat mechanics with health and attack damage.
- Implement a save/load feature.
- Expand the world with more areas and quests.

---
**Author:** Madiyar  
**Language:** Java  
**License:** MIT

