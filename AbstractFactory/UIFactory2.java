package AbstractFactory;

public class UIFactory2 extends UIFactory {

    public Button addButton (String text) {
        return new Button2(text);
    }

    public Checkbox addCheckbox (String text) {
        return new CheckBox2(text);
    }

    public TextField addTextField (String text) {
        return new TextField2(text);
    }
}
