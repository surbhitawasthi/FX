package ScaleTransition;


import com.jfoenix.controls.JFXButton;
import javafx.animation.ScaleTransition;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.scene.control.Alert;
import javafx.util.Duration;

public class ScaleTransitionController implements Initializable
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

        transition.setToY(-200);
        transition.setToX(-100);
        transition.setAutoReverse(true);
        transition.setCycleCount(2);
        transition.play();

        ScaleTransition scaleTransition=new ScaleTransition(Duration.seconds(4),bt);
        scaleTransition.setToX(-1);
        scaleTransition.setToY(-1);
        scaleTransition.setAutoReverse(true);
        scaleTransition.setCycleCount(2);

        scaleTransition.play();

//        transition.setOnFinished(e->
//        {
//            Alert alert=new Alert(Alert.AlertType.INFORMATION);
//            alert.setContentText("Complete Transition");
//            alert.show();
//        });
    }
}
