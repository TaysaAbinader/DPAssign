package AbstractFactory;

public class TextField2 extends TextField {

    public TextField2 (String text) {
        super(text);
    }

    public void display () {
        System.out.println(this.text + "\n ______________");
    }
}
