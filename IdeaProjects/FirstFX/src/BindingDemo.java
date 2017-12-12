import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.stage.Stage;

public class BindingDemo extends Application
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
        window.setTitle("Binding");

        IntegerProperty x=new SimpleIntegerProperty(this,"x",3);
        IntegerProperty y=new SimpleIntegerProperty();

        y.bind(x.multiply(10));

        System.out.println("x: "+ x.getValue());
        System.out.println("y: "+ y.getValue()+"\n");

        x.setValue(9);

        System.out.println("x: "+ x.getValue());
        System.out.println("y: "+ y.getValue()+"\n");
    }
}
