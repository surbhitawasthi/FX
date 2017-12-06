import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SwitchingScene extends Application
{
    Stage window;
    Scene scene1,scene2;
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        window = primaryStage;
        window.setTitle("Scene Switching: Scene 1");
        Label lb1=new Label();
        lb1.setText("Welcome to scene switching");

        Button bt1=new Button("Goto scene 2");
        bt1.setOnAction(e ->
        {
            window.setTitle("Scene Switching:Scene 2");
            window.setScene(scene2);
        });

        VBox vb=new VBox(20);
        vb.getChildren().addAll(lb1, bt1);

        Button bt2=new Button("This scene is very bad go back to scene 1");
        bt2.setOnAction(e->
        {
            window.setTitle("Scene Switching:Scene 1");
            window.setScene(scene1);
        });

        StackPane sp=new StackPane();
        sp.getChildren().add(bt2);

        scene1=new Scene(vb,300,250);
        scene2=new Scene(sp, 600,400);

        window.setScene(scene1);
        window.show();
    }

    public static void main(String args[])
    {
        launch(args);
    }
}
