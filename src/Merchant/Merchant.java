package com.example.mud;

import java.util.List;

public class Merchant extends NPC {

    private List<Item> goods;

    public Merchant(String name, String description, String address, List<Item> goods) {
        super(name, description, address);
        this.goods = goods;
    }

    @Override
    public void describe() {
        System.out.println("Торговец: " + name);
        System.out.println("Описание: " + description);
        System.out.println("Товары в наличии:");
        if (goods != null && !goods.isEmpty()) {
            for (Item item : goods) {
                System.out.println(" - " + item.getName() + ": " + item.getDescription());
            }
        } else {
            System.out.println("Нет товаров.");
        }
    }

    public void trade(Player player) {
        if (goods != null && !goods.isEmpty()) {
            Item purchased = goods.remove(0);
            player.addItem(purchased);
            System.out.println("Вы купили: " + purchased.getName());
        } else {
            System.out.println("У торговца нет товаров для продажи.");
        }
    }
}
