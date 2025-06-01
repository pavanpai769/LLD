package model;

import model.buttons.Button;
import model.buttons.ExternalButton;

public class ExternalPanel {
    private final int currentFloorNumber;
    private Display display;
    private final Button down;
    private final Button up;

    public ExternalPanel(int currentFloorNumber) {
        this.currentFloorNumber = currentFloorNumber;
        this.display = new Display();
        this.down = new ExternalButton(currentFloorNumber,"down");
        this.up = new ExternalButton(currentFloorNumber,"up");
    }
}
