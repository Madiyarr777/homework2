package mypackage;

public class Door {
    private boolean isOpen;

    public Door() {
        this.isOpen = false;
    }

    public void open() {
        isOpen = true;
    }

    public void close() {
        isOpen = false;
    }

    public boolean isOpen() {
        return isOpen;
    }
}
