package FadingScenes;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerFor1 implements Initializable
{
    public Button btToScene2;
    public VBox vb;

    public void btClicked()throws Exception
    {
        btToScene2.setDisable(true);
        FadeTransition fadeOut=new FadeTransition();
        fadeOut.setDuration(Duration.millis(500));
        fadeOut.setNode(vb);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);
        fadeOut.play();

        fadeOut.setOnFinished(e->
        {
            Parent root = null;
            try
            {
                root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
            }
            catch (IOException e1)
            {
                e1.printStackTrace();
            }
            Stage curStage = (Stage) vb.getScene().getWindow();
            curStage.setScene(new Scene(root,600,450));
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        vb.setOpacity(0);
        fadeInTransition();
    }

    private void fadeInTransition()
    {

        FadeTransition fdIn=new FadeTransition(Duration.seconds(1),vb);
        fdIn.setFromValue(0.0);
        fdIn.setToValue(1.0);
        fdIn.play();
        fdIn.setOnFinished(e->btToScene2.setDisable(false));
    }
}
