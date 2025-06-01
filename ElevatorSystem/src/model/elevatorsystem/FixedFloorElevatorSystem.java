package model.elevatorsystem;

import model.ElevatorCar;
import model.buttons.Button;
import model.buttons.InternalButton;
import model.elevatorcontroller.FixedFloorElevatorSystemController;

import java.util.ArrayList;
import java.util.List;

public class FixedFloorElevatorSystem extends ElevatorSystem {

    private ElevatorCar elevatorCar;

    public FixedFloorElevatorSystem(int numberOfFloors) {
        super(numberOfFloors,new FixedFloorElevatorSystemController());

        List<Button> floorButtons = new ArrayList<>();
        for (int i = 0; i < numberOfFloors; i++) {
            floorButtons.add(new InternalButton(i));
        }

        this.elevatorCar = new ElevatorCar(floorButtons);
    }

}
