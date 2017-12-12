import com.sun.javafx.scene.SceneEventDispatcher;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainForPropertyDemo extends Application
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
        window.setTitle("Properties");

        PropertyDemo surbhit = new PropertyDemo();

        surbhit.firstNameProperty().addListener( (v, oldValue, newValue) ->
        {
            System.out.println("Name changed to: "+newValue);
            System.out.println("firstNameProperty(): "+surbhit.firstNameProperty());
            System.out.println("getFirstName: "+surbhit.getFirstName());
        });

        Button bt=new Button("Submit");
        bt.setOnAction(e->surbhit.setFirstName("Ishita"));

        StackPane sp=new StackPane();
        sp.getChildren().add(bt);

        Scene sc=new Scene(sp, 300, 250);
        window.setScene(sc);
        window.show();
    }
}
