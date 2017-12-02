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


public class Main extends Application
{
    Button bt1, bt2;
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("FirstFX");
        //bt1=new Button();
        bt2=new Button();
        //bt1.setText("Click Me!");
        bt2.setText("Dont click me");
        /*bt1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Yoyoyo");
            }
        });*/

        //LAMBDA INTERFACE

        //bt1.setOnAction(e -> System.out.println("Lambda wali calling"));
        bt2.setOnAction(e -> {
            System.out.println("Second button clicked");
            System.out.println("Have fun");
        });
        StackPane layout=new StackPane();
        //layout.getChildren().add(bt1);
        layout.getChildren().add(bt2);
        Scene scene=new Scene(layout, 300,250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
