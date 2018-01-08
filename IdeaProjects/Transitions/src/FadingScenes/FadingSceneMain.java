package FadingScenes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FadingSceneMain extends Application
{
    public static void main(String args[])
    {
        launch(args);
    }

    Stage window;
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        window=primaryStage;
        window.setTitle("Scene change with Transition");
        Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
        window.setScene(new Scene(root,600,450));
        window.show();
    }
}
