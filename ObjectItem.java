package mypackage;

public record ObjectItem(String name, String description) implements Entityinterface {

    @Override
    public String description() {
        return "Предмет: " + name + " - " + description;
    }

    @Override
    public void interact() {

    }
}
