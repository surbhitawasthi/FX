import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BindingAndProperty extends Application
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
        window.setTitle("Binding and Properties");

        //Inputs and Labels
        TextField userInput = new TextField();
        userInput.setMaxWidth(200);

        Label firstLabel=new Label("Welcome to the app ");
        Label secondLabel=new Label();

        HBox hb=new HBox(10);
        hb.setAlignment(Pos.CENTER);
        hb.getChildren().addAll(firstLabel,secondLabel);

        secondLabel.textProperty().bind(userInput.textProperty());

        VBox vb=new VBox(10,userInput,hb);
        vb.setAlignment(Pos.CENTER);
        Scene sc=new Scene(vb, 300,250);
        window.setScene(sc);
        window.show();
    }
}
