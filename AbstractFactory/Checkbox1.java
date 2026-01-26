package AbstractFactory;

public class Checkbox1 extends Checkbox {

    public Checkbox1 (String text) {
        super(text);
    }

    public void display () {
        System.out.println("( )" + this.text + " 1\n( )" + this.text + " 2");
    }
}
