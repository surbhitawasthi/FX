package FadingScenes;

import com.jfoenix.controls.JFXButton;
import javafx.animation.FadeTransition;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerFor2 implements Initializable
{
    public StackPane sp;
    public JFXButton btToScene1;

    public  void loading()
    {
        FadeTransition fadeIn=new FadeTransition();
        fadeIn.setDuration(Duration.seconds(1));
        fadeIn.setNode(sp);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();

        fadeIn.setOnFinished(e->btToScene1.setDisable(false));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        sp.setOpacity(0);
        loading();
    }

    public void loadScene1()
    {
        btToScene1.setDisable(true);
        FadeTransition fadeOut=new FadeTransition(Duration.seconds(0.5),sp);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);
        fadeOut.play();

        fadeOut.setOnFinished(e->
        {
            Parent root=null;
            try
            {
                root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
            }
            catch(Exception e1)
            {
                e1.printStackTrace();
            }
            Stage curWindow = (Stage) sp.getScene().getWindow();
            Scene sc=new Scene(root,600,450);
            curWindow.setScene(sc);

        });
    }
}
