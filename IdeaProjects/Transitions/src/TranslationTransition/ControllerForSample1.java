package TranslationTransition;


import com.jfoenix.controls.JFXButton;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.scene.control.Alert;
import javafx.util.Duration;

public class ControllerForSample1 implements Initializable
{
    public JFXButton bt;

    public void btClicked()
    {
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Button Clicked Output");
        alert.setHeaderText("Hey there,");
        alert.setContentText("You pressed me!!!");
        alert.show();
        //System.out.println("Button Clicked");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        TranslateTransition transition=new TranslateTransition();
        transition.setDuration(Duration.seconds(4));
        transition.setNode(bt);
        /*
            All these line can be written as
            TranslateTransition transition1=new TranslateTransition(Duration.seconds(4),bt);
        */
        transition.setToY(-200);
        transition.setToX(-100);
        /*try commenting autoReverse functions*/
        transition.setAutoReverse(true);
        //transition.setCycleCount(TranslateTransition.INDEFINITE);
        transition.setCycleCount(2);
        transition.play();

        transition.setOnFinished(e->
        {
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Complete Transition");
            alert.show();
        });
    }
}
