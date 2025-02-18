package mypackage;

public class GameLauncher {
    public static void main(String[] args) {
        GameEngine engine = new GameEngine();
        engine.startGame();

        Adventurer hero = new Adventurer("Герой");

        ForestArea forest = new ForestArea("Темный лес", "Здесь очень мрачно и страшно.");

        ObjectItem sword = new ObjectItem("Меч", "Старый ржавый меч.");

        Monster goblin = new Monster("Гоблин", 5);

        NPC oldMan = new NPC("Старик", "Хранитель леса");

        System.out.println(hero.getName() + " входит в локацию...");
        System.out.println(forest.description());
        System.out.println(sword.description());
        System.out.println(goblin.description());
        System.out.println(oldMan.description());
    }
}
