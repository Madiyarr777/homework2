package mypackage;

public  class NPC implements Entityinterface {
    private final String name;
    private final String role;

    public NPC(String name, String role) {
        this.name = name;
        this.role = role;
    }

    @Override
    public String description() {
        return "NPC: " + name + " - " + role;
    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public void interact() {

    }
}
