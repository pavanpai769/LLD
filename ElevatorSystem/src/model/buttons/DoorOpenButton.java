package model.buttons;

public class DoorOpenButton implements Button {
    private String text;

    public DoorOpenButton(String text) {
        this.text = text;
    }

    @Override
    public void press(){

    }

    public String getText() {
        return text;
    }
}
