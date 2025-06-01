package model.buttons;

public class DoorCloseButton implements Button {
    private String text;

    public DoorCloseButton(String text) {
        this.text = text;
    }

    @Override
    public void press(){

    }

    public  String getText() {
        return text;
    }

}
