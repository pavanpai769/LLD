package model.buttons;

public class ExternalButton implements Button {
    private final int floorNumber;
    private final String direction;

    public ExternalButton(int floorNumber, String direction) {
        this.floorNumber = floorNumber;
        this.direction = direction;
    }

    @Override
    public void press(){

    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public String getDirection() {
        return direction;
    }
}
