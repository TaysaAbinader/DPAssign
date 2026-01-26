package AbstractFactory;

public class Application {

    public static void main(String[] args) {

        UIFactory uiFactory = new UIFactory1();

        Button button = uiFactory.addButton("OK");
        Checkbox checkbox = uiFactory.addCheckbox("option");
        TextField textField = uiFactory.addTextField("Name");

        button.display();
        checkbox.display();
        textField.display();

        button.setText("Submit");
        checkbox.setText("FALSE");
        textField.setText("Age");

        button.display();
        checkbox.display();
        textField.display();

        uiFactory = new UIFactory2();

        button = uiFactory.addButton("OK");
        checkbox = uiFactory.addCheckbox("option");
        textField = uiFactory.addTextField("Name");

        button.display();
        checkbox.display();
        textField.display();

    }
}
