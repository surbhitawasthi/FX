package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main extends Application implements EventHandler<ActionEvent>
{
    Button bt;
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("FirstFX");
        bt=new Button();
        bt.setText("Click Me!");

        bt.setOnAction(this);

        StackPane layout=new StackPane();
        layout.getChildren().add(bt);
        Scene scene=new Scene(layout, 300,250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void handle(ActionEvent event)
    {
        if(event.getSource().equals(bt))
            System.out.println("Button is clicked");
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
