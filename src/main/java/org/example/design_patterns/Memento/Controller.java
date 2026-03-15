package org.example.design_patterns.Memento;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Controller {
    private Model model;
    private Gui gui;
    private List<IMemento> history; // Memento history
    private List<IMemento> redoList = new ArrayList<>();


    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
        this.redoList = new ArrayList<>();

    }

    public void setOption(int optionNumber, int choice) {
        saveToHistory();
        model.setOption(optionNumber, choice);
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        saveToHistory();
        model.setIsSelected(isSelected);
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void undo() {
        if (!history.isEmpty()) {
            System.out.println("Memento found in history");
            redoList.add(model.createMemento());
            IMemento previousState = history.remove(history.size() - 1);
            model.restoreState(previousState);
            gui.updateGui();
            gui.refreshHistoryWindow();
        }
    }

    public void redo() {
        if (!redoList.isEmpty()) {
            history.add(model.createMemento());
            IMemento nextState = redoList.remove(redoList.size() - 1);
            model.restoreState(nextState);
            gui.updateGui();
            gui.refreshHistoryWindow();
        }
    }

    public void restoreFromHistory(IMemento memento) {
        history.add(model.createMemento());
        redoList.clear();
        model.restoreState(memento);
        gui.updateGui();
        gui.refreshHistoryWindow();
    }

    private void saveToHistory() {
        IMemento currentState = model.createMemento();
        history.add(currentState);
        redoList.clear();
        if (gui != null) {
            gui.refreshHistoryWindow();
        }
    }

    public List<IMemento> getHistory() {
        return history;
    }
}
