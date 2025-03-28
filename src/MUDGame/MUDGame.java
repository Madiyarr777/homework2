package com.example.mud;

import java.util.ArrayList;
import java.util.List;

public class MUDGame {
    public static void main(String[] args) {

        Room startRoom = new Room("Начальная комната", "Здесь вы начинаете своё приключение.");
        Room castle = new Room("Замок Дракулы", "Это зловещий замок, полный тайн и опасностей.");
        Room wastelands = new Room("Пустоши", "Пустынные земли, где царствует одиночество и забвение.");

        startRoom.addNeighbor("east", castle);
        startRoom.addNeighbor("west", wastelands);

        castle.addNeighbor("west", startRoom);
        wastelands.addNeighbor("east", startRoom);

        Monster monster = new Monster("Гоблин", "Злобный гоблин", "подземелье", 50);

        List<Item> merchantGoods = new ArrayList<>();
        merchantGoods.add(new Item("Зелье здоровья", "Восстанавливает 20 здоровья"));
        merchantGoods.add(new Item("Кинжал", "Небольшое, но острое оружие"));

        Merchant merchant = new Merchant("Торговец", "Торговец с разнообразными товарами", "рынок", merchantGoods);

        startRoom.addNPC(monster);
        startRoom.addNPC(merchant);

        Player player = new Player(startRoom);

        MUDController controller = new MUDController(player);
        controller.runGameLoop();
    }
}
