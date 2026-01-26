package AbstractFactory;

public class CheckBox2 extends Checkbox {

    public CheckBox2 (String text) {
        super(text);
    }

    public void display () {
        System.out.println("[ ]" + this.text + "1\n[ ]" + this.text + "2");
    }
}
