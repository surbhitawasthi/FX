package FadeTransition;


import com.jfoenix.controls.JFXButton;
import javafx.animation.*;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Controller implements Initializable
{
    public JFXButton bt;

    public void btClicked()
    {
//        Alert alert=new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Button Clicked Output");
//        alert.setHeaderText("Hey there,");
//        alert.setContentText("You pressed me!!!");
//        alert.show();
//        //System.out.println("Button Clicked");

        /*Fade in transition when button clicked*/

        FadeTransition fdIn=new FadeTransition(Duration.seconds(2),image);
        fdIn.setFromValue(0.0);
        fdIn.setToValue(1.0);
        fdIn.play();

    }

    public ImageView image;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        TranslateTransition transition=new TranslateTransition();
        transition.setDuration(Duration.seconds(4));
        transition.setNode(bt);

        transition.setToY(-200);
        transition.setToX(-100);
        //transition.setAutoReverse(true);
        //transition.setCycleCount(2);



        ScaleTransition scaleTransition=new ScaleTransition(Duration.seconds(4),bt);
        scaleTransition.setToX(2);
        scaleTransition.setToY(2);
        //scaleTransition.setAutoReverse(true);
        //scaleTransition.setCycleCount(2);



        //RotateTransition rotateTransition=new RotateTransition(Duration.seconds(4),image);
        RotateTransition rotateTransition=new RotateTransition(Duration.seconds(4),bt);
        rotateTransition.setByAngle(360);
        /*
        rotateTransition.setFromAngle(45);
        rotateTransition.setToAngle(180);
        */

//        transition.play();
//        scaleTransition.play();
//        rotateTransition.play();
//        Using Parallel transition

        ParallelTransition parallelTransition=new ParallelTransition(transition,scaleTransition,rotateTransition);

        parallelTransition.setAutoReverse(true);
        parallelTransition.setCycleCount(2);

        parallelTransition.play();

        //parallelTransition.setOnFinished(e-> System.out.println("Completed"));

        /*Now what we want is to fade out the background when all animations are over*/

        parallelTransition.setOnFinished(e->
        {
            FadeTransition fdOut=new FadeTransition(Duration.seconds(2),image);
            fdOut.setFromValue(1.0);
            fdOut.setToValue(0.0);
            fdOut.play();
        });

    }
}
