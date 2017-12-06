import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class AlertBoxStartingWindow extends Application
{
    static Stage window;
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        window = primaryStage;
        window.setTitle("Alert Boxes");

        Button bt=new Button("Click me!!!");
        bt.setOnAction(e -> AlertBox.display("title for alert box","Alert box label"));

        StackPane sp=new StackPane();
        sp.getChildren().add(bt);

        Scene s1= new Scene(sp, 300, 250);

        window.setScene(s1);
        window.show();
    }

    public static void main(String args[])
    {
        launch(args);
    }
}
