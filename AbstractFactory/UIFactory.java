package AbstractFactory;

public abstract class UIFactory {

    public abstract Button addButton(String text);

    public abstract Checkbox addCheckbox(String text);

    public abstract TextField addTextField(String text);

}
