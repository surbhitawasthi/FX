package sample;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
    //To make a code run before the main GUI loads we use Initializable
    //We implement Initializable and its function initialize
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        System.out.println("Loading user data");
    }
}
