package com.example.mud;

public class Monster extends NPC {

    private int health;

    public Monster(String name, String description, String address, int health) {
        super(name, description, address);
        this.health = health;
    }

    @Override
    public void describe() {
        System.out.println("Монстр: " + name);
        System.out.println("Описание: " + description);
        System.out.println("Здоровье: " + health);
    }

    public void attack(Player player) {
        int damage = 10; // Фиксированный урон для примера
        System.out.println("Монстр " + name + " атакует игрока и наносит " + damage + " урона!");
        player.takeDamage(damage);
    }


    public void takeDamage(int damage) {
        health -= damage;
        System.out.println("Монстр " + name + " получает " + damage + " урона. Осталось здоровья: " + health);
    }

    public int getHealth() {
        return health;
    }
}
