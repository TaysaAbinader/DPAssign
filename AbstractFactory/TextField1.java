package AbstractFactory;

public class TextField1 extends TextField {

    public TextField1 (String text) {
        super(text);
    }

    public void display () {
        System.out.println(this.text + ": ______________");
    }
}
