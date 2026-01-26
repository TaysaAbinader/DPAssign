package AbstractFactory;

public abstract class Widget {
    protected String text;

    public Widget (String text) {
        this.text = text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public abstract void display();
}
