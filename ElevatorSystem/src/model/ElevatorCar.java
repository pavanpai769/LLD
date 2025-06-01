package model;

import model.buttons.Button;
import model.buttons.DoorCloseButton;
import model.buttons.DoorOpenButton;

import java.util.List;

public class ElevatorCar {
    private final Display display;
    private List<Button> floorButtons;
    private final Door door;
    private final Button doorOpenButton;
    private final Button doorCloseButton;

    public ElevatorCar(List<Button> floorButtons ) {
        this.display = new Display();
        this.floorButtons = floorButtons;
        this.door = new Door();
        this.doorOpenButton = new DoorOpenButton("<>");
        this.doorCloseButton = new DoorCloseButton("><");

    }

    public Display getDisplay() {
        return display;
    }

    public List<Button> getFloorButtons() {
        return floorButtons;
    }

    public void setFloorButtons(List<Button> floorButtons) {
        this.floorButtons = floorButtons;
    }

    public Button getDoorOpenButton() {
        return doorOpenButton;
    }

    public Door getDoor() {
        return door;
    }

    public Button getDoorCloseButton() {
        return doorCloseButton;
    }
}
