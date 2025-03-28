package com.example.mud;

import java.util.Scanner;

public class MUDController {

    private final Player player;
    private boolean running;

    public MUDController(Player player) {
        this.player = player;
        this.running = true;
    }

    public void runGameLoop() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в MUD! Введите 'help' для списка команд.");

        while (running) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            handleInput(input);
        }

        System.out.println("Игра завершена. До свидания!");
        scanner.close();
    }

    public void handleInput(String input) {
        if (input.isEmpty()) {
            return;
        }

        String[] parts = input.split("\\s+", 2);
        String command = parts[0].toLowerCase();
        String arg = (parts.length > 1) ? parts[1] : "";

        switch (command) {
            case "look":
                lookAround();
                break;
            case "move":
                move(arg);
                break;
            case "pick":
                pickUp(arg);
                break;
            case "inventory":
                checkInventory();
                break;
            case "attack":
                attack(arg);
                break;
            case "trade":
                trade(arg);
                break;
            case "help":
                showHelp();
                break;
            case "quit":
            case "exit":
                running = false;
                break;
            default:
                System.out.println("Неизвестная команда: " + command);
                break;
        }
    }

    private void lookAround() {
        Room currentRoom = player.getCurrentRoom();
        if (currentRoom == null) {
            System.out.println("Вы находитесь в пустоте... (нет текущей комнаты)");
            return;
        }
        currentRoom.describe();
    }

    private void move(String direction) {
        if (direction.isEmpty()) {
            System.out.println("Укажите направление, куда двигаться (например: move east).");
            return;
        }
        Room currentRoom = player.getCurrentRoom();
        Room nextRoom = currentRoom.getNeighbor(direction);
        if (nextRoom != null) {
            player.setCurrentRoom(nextRoom);
            System.out.println("Вы перемещаетесь в направлении " + direction + "...");
            nextRoom.describe();
        } else {
            System.out.println("В этом направлении нет пути.");
        }
    }

    private void pickUp(String arg) {
        if (arg.isEmpty()) {
            System.out.println("Укажите, что вы хотите поднять (например: pick sword).");
            return;
        }
        System.out.println("Вы пытаетесь поднять: " + arg);
        System.out.println("Предмет \"" + arg + "\" добавлен в инвентарь (заглушка).");
    }

    private void checkInventory() {
        if (player.getInventory().isEmpty()) {
            System.out.println("Ваш инвентарь пуст.");
        } else {
            System.out.println("В инвентаре:");
            for (Item item : player.getInventory()) {
                System.out.println(" - " + item.getName() + ": " + item.getDescription());
            }
        }
    }

    private void attack(String npcName) {
        if (npcName.isEmpty()) {
            System.out.println("Укажите, кого атаковать (например: attack goblin).");
            return;
        }

        Room currentRoom = player.getCurrentRoom();
        NPC npc = currentRoom.getNPC(npcName);
        if (npc == null) {
            System.out.println("В комнате нет NPC с именем: " + npcName);
            return;
        }

        if (npc instanceof Monster) {
            Monster monster = (Monster) npc;
            int playerDamage = 20;
            System.out.println("Вы атакуете монстра " + monster.getName() + " и наносите " + playerDamage + " урона.");
            monster.takeDamage(playerDamage);
            if (monster.getHealth() > 0) {

                monster.attack(player);
            } else {
                System.out.println("Монстр " + monster.getName() + " побеждён!");
                currentRoom.removeNPC(monster);
            }
        } else {
            System.out.println("NPC " + npcName + " не является монстром, его атаковать нельзя.");
        }
    }

    private void trade(String npcName) {
        if (npcName.isEmpty()) {
            System.out.println("Укажите, с кем торговаться (например: trade merchant).");
            return;
        }

        Room currentRoom = player.getCurrentRoom();
        NPC npc = currentRoom.getNPC(npcName);
        if (npc == null) {
            System.out.println("В комнате нет NPC с именем: " + npcName);
            return;
        }

        if (npc instanceof Merchant) {
            Merchant merchant = (Merchant) npc;
            merchant.trade(player);
        } else {
            System.out.println("NPC " + npcName + " не является торговцем.");
        }
    }

    private void showHelp() {
        System.out.println("Доступные команды:");
        System.out.println("  look                - осмотреться");
        System.out.println("  move <dir>          - переместиться (например: east, west)");
        System.out.println("  pick <item>         - поднять предмет");
        System.out.println("  inventory           - показать инвентарь");
        System.out.println("  attack <npc_name>   - атаковать монстра");
        System.out.println("  trade <npc_name>    - торговаться с торговцем");
        System.out.println("  help                - показать помощь");
        System.out.println("  quit/exit           - выйти из игры");
    }
}
