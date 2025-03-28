package com.example.mud;

import java.util.ArrayList;
import java.util.List;

 class Player {

    private List<Item> inventory = new ArrayList<>();
    private Room currentRoom;
    private int health = 100;

    public Player(Room startRoom) {
        this.currentRoom = startRoom;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        health -= damage;
        System.out.println("Игрок получил " + damage + " урона. Здоровье: " + health);
        if (health <= 0) {
            System.out.println("Вы погибли! Игра окончена.");
            System.exit(0);
        }
    }
}
