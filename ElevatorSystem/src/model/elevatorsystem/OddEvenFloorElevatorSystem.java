package model.elevatorsystem;

import model.ElevatorCar;
import model.buttons.Button;
import model.buttons.InternalButton;
import model.elevatorcontroller.ElevatorController;
import model.elevatorcontroller.OddEvenFloorElevatorSystemController;
import model.utility.Pair;

import java.util.ArrayList;
import java.util.List;


public class OddEvenFloorElevatorSystem extends ElevatorSystem {
    private  Pair<ElevatorCar, ElevatorCar> elevatorCars;

    public OddEvenFloorElevatorSystem(int floors) {

        super(floors, new OddEvenFloorElevatorSystemController());

        List<Button> oddButtons = new ArrayList<>();
        List<Button> evenButtons = new ArrayList<>();

        for(int i = 0; i < floors; i++) {
            if(i % 2 == 0) {
                evenButtons.add(new InternalButton(i));
            }else{
                oddButtons.add(new InternalButton(i));
            }
        }

        ElevatorCar oddFloorElevatorCar = new ElevatorCar(oddButtons);
        ElevatorCar evenFloorElevatorCar = new ElevatorCar(evenButtons);

        elevatorCars = new Pair<>(oddFloorElevatorCar, evenFloorElevatorCar);

    }
}
