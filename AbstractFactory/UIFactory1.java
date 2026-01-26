package AbstractFactory;

public class UIFactory1 extends UIFactory{

    public Button addButton (String text) {
        return new Button1(text);
    }

    public Checkbox addCheckbox (String text) {
        return new Checkbox1(text);
    }

    public TextField addTextField (String text) {
        return new TextField1(text);
    }

}
