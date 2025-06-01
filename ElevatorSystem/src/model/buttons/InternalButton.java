package model.buttons;

public class InternalButton implements Button {
    private final int floorNumber;

    public InternalButton(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Override
    public void press(){

    }

    public int getFloorNumber() {
        return floorNumber;
    }
}
