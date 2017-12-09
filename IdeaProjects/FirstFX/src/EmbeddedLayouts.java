import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.*;

public class EmbeddedLayouts extends Application
{
    public static void main(String args[])
    {
        launch(args);
    }

    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        window = primaryStage;

        HBox hb=new HBox(10);
        Button bt1=new Button("BT 1");
        Button bt2=new Button("BT 2");
        Button bt3=new Button("BT 3");
        hb.getChildren().addAll(bt1, bt2, bt3);

        VBox vb=new VBox(10);
        Button bt4=new Button("BT 4");
        Button bt5=new Button("BT 5");
        Button bt6=new Button("BT 6");
        vb.getChildren().addAll(bt4,bt5,bt6);

        BorderPane bp=new BorderPane();
        bp.setTop(hb);
        bp.setLeft(vb);

        Scene scene=new Scene(bp,300,250);
        window.setScene(scene);
        window.setTitle("Title");
        window.show();
    }
}
