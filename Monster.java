package mypackage;

public  class Monster implements Entityinterface {
    private final String name;
    private final int strength;

    public Monster(String name, int strength) {
        this.name = name;
        this.strength = strength;
    }

    @Override
    public String description() {
        return "Монстр: " + name + " (Сила: " + strength + ")";
    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public void interact() {

    }
}
