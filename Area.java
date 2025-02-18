package mypackage;

public  class Area implements Entityinterface {

    private final String title;
    private final String info;

    public Area(String title, String info) {
        this.title = title;
        this.info = info;
    }

    @Override
    public String description() {
        return "Вы находитесь в локации: " + title + ". " + info;
    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public void interact() {

    }

}
