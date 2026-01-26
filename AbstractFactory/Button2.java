package AbstractFactory;

public class Button2 extends Button {

    public Button2 (String text) {
        super(text);
    }

    public void display() {
        System.out.println("[ " + this.text + " ]");
    }

}
