package model.elevatorsystem;

import model.elevatorcontroller.ElevatorController;


public abstract class ElevatorSystem {
    private int numberOfFloors;
    private ElevatorController elevatorController;

    public ElevatorSystem(int numOfFloors,ElevatorController elevatorController) {
        this.numberOfFloors = numOfFloors;

    }
}
