import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChoiceAndComboBoxesDemo extends Application
{
    Stage window;
    public static void main(String args[])
    {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        window=primaryStage;
        window.setTitle("Check Boxes");

        ChoiceBox<String> cb=new ChoiceBox<>();
        cb.getItems().addAll("Apples","Banana","Grapes","Orange","Tamato");
        //setting default choicebox value
        cb.setValue("Apples");

        Button bt=new Button("Send");
        bt.setOnAction(e-> System.out.println("Button output: "+cb.getValue()));

        //choicebox doesnt creates it ow actions events when selection is changed
        //whereas combobox has its selection action
        //Actions can be also listened at the event of change of selection like this
        cb.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> System.out.println(oldValue+"->"+newValue));

        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Potato","sugar","rice","spainich");
        comboBox.setPromptText("What do you want to buy");
        //this cant be done by choice box
        comboBox.setOnAction(e -> System.out.println(comboBox.getValue()));

        ComboBox<String> comboBox2 = new ComboBox<>();
        comboBox2.getItems().addAll("Potato","sugar","rice","spainich");

        comboBox2.setEditable(true);

        //this cant be done by choice box
        comboBox2.setOnAction(e -> System.out.println(comboBox2.getValue()));

        Label lb1=new Label("ComboBox");
        Label lb2=new Label("ChoiceBox");
        Label lb3=new Label("ComboBox with editable true");

        VBox vb=new VBox(10);
        vb.setPadding(new Insets(20,20,20,20));
        vb.getChildren().addAll(lb1, comboBox, lb2, cb, lb3, comboBox2, bt);

        Scene sc = new Scene(vb, 300,400);
        window.setScene(sc);
        window.show();
    }
}
