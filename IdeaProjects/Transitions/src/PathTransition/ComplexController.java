package PathTransition;

import com.jfoenix.controls.JFXButton;
import javafx.animation.PathTransition;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class ComplexController implements Initializable
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
        mouseMotion.setText("X = " + "\t\t\tY =");

        PathTransition pathTransition=new PathTransition();
        pathTransition.setNode(bt);
        pathTransition.setDuration(Duration.seconds(3));
        pathTransition.setCycleCount(-1);

        Path path=new Path();
        path.getElements().add(new MoveTo(0,0));//Making initial position of the object as (0,0) relatively
        //path.getElements().add(new HLineTo(-200));
        //path.getElements().add(new VLineTo(100));
        //path.getElements().add(new LineTo(200,-100));

//        ArcTo arcTo=new ArcTo();
//        arcTo.setX(100);
//        arcTo.setY(150);/*(x,y) from initial position*/
//        arcTo.setRadiusX(50);
//        arcTo.setRadiusY(50);
//
//        path.getElements().add(arcTo);
//        path.getElements().add(new ClosePath());


//        path.getElements().add(new CubicCurveTo(300,0,300,120,200,120));
//        path.getElements().add(new CubicCurveTo(0,120,0,240,380,240));

        path.getElements().add(new QuadCurveTo(250,100,150,100));
        path.getElements().add(new QuadCurveTo(150,100,-100,-150));

        pathTransition.setPath(path);

        pathTransition.play();
    }
}
