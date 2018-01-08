package PathTransition;

import com.jfoenix.controls.JFXButton;
import javafx.animation.PathTransition;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
    public JFXButton bt;
    //public Label lb;
    public Text mouseMotion;//Text is a shape

    public void btClicked()
    {
        System.out.println("Button Clicked");
    }

    public void setCoordinates(MouseEvent event)
    {
        mouseMotion.setText("X = "+event.getX()+"\t\t\tY ="+event.getY());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        mouseMotion.setText("X = "+"\t\t\tY =");

        Circle circle=new Circle(100);
        Rectangle rectangle=new Rectangle(100,200);
        Polyline polyline=new Polyline();
        polyline.getPoints().addAll(new Double[]{
           0.0,0.0,
           200.0,100.0,
           100.0,200.0
        });

        PathTransition pathTransition=new PathTransition();
        pathTransition.setNode(bt);
        pathTransition.setDuration(Duration.seconds(3));

        //pathTransition.setPath(mouseMotion); // Dont know what happens
        //pathTransition.setPath(circle);
        pathTransition.setPath(polyline);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);

        pathTransition.setCycleCount(PathTransition.INDEFINITE);
        pathTransition.play();
    }
}
