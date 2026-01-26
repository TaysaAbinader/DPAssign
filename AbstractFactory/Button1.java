package AbstractFactory;

public class Button1 extends Button {

    public Button1 (String text) {
        super(text);
    }

    public void display() {
        System.out.println("<<< " + this.text + " >>>");
    }


}
