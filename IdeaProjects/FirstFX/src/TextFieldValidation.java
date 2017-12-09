import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TextFieldValidation extends Application
{

    Stage window;

    public static void main(String args[])
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        window = primaryStage;
        TextField tf=new TextField();
        //Light grey text which disappears and reappears
        tf.setPromptText("Age");

        Button bt=new Button("Send !");
        bt.setOnAction(e-> isNum(tf, tf.getText()));
        

        VBox vb=new VBox(10);
        vb.setAlignment(Pos.CENTER);
        vb.getChildren().addAll(tf,bt);

        Scene sc=new Scene(vb, 300, 250);
        window.setTitle("Title");
        window.setScene(sc);
        window.show();

    }

    private static boolean isNum(TextField tf,String str)
    {
        try
        {
            int n=Integer.parseInt(str);
            System.out.println("Age is "+n);
            return true;
        }
        catch(Exception e)
        {
            System.out.println("Some exception occured not a number "+str);
            return false;
        }
    }

}
