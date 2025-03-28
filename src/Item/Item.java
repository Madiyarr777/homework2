package com.example.mud;

public class Item implements IGameEntity {

    private String name;
    private String description;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public void describe() {
        System.out.println("Предмет: " + name);
        System.out.println("Описание: " + description);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
