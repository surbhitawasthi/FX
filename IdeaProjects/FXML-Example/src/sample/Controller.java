package sample;

import javafx.scene.control.Button;

public class Controller
{
    public Button button;

    public void handleButtonClick()
    {
        System.out.println("Button Pressed");
        button.setText("Stop Clicking broh..");
    }
}
