import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ClosingAndSaving extends Application
{
    static Stage window;
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        window = primaryStage;
        window.setTitle("Closing windows");

        //when the top right close button is pressed
        //this request is to close ie whatever the result of the code passed
        // is i just dont care and wanna close the window
        /*
            window.setOnCloseRequest() is equivalent to
            bt.setOnAction(e->
            {
                closeWindow();
                window.close();
            });
        */
        window.setOnCloseRequest(e->closeWindow());

        //to handle this problem we have comsume()
        window.setOnCloseRequest(e->
        {
            e.consume();
            closeWindow();
        });

        Button bt=new Button("Close");
        //when our close button is pressed
        //here the window.close() depends upon the result of code running
        bt.setOnAction(e->closeWindow());

        StackPane sp=new StackPane();
        sp.getChildren().add(bt);

        Scene s1= new Scene(sp, 300, 250);

        window.setScene(s1);
        window.show();
    }

    private static void closeWindow()
    {
        System.out.println("Inside clsoeWindow");
        Boolean res=ConfirmBox.display("TITLE","Do you really want to close");
        if(res)
        {
            System.out.println("Bye bye");
            window.close();
        }
    }
    public static void main(String args[])
    {
        launch(args);
    }
}
