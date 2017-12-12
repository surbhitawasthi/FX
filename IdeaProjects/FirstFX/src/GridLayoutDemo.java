import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridLayoutDemo extends Application
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
        window.setTitle("Grid Layout");

        Label userLb=new Label("Username");
        Label passwdLb=new Label("Password");

        TextField username=new TextField("Surbhit");
        //username.setPromptText("Enter name");

        PasswordField passwd=new PasswordField();
        passwd.setPromptText("Enter password");

        Button bt=new Button("Log In");
        bt.setOnAction(e->
        {
            printDetails(username.getText(),passwd.getText());
            //Line to change Theme
            //setUserAgentStylesheet(STYLESHEET_CASPIAN);
        });

        GridPane gp=new GridPane();
        gp.setPadding(new Insets(20,20,20,20));
        gp.setHgap(10);
        gp.setVgap(20);
        gp.setConstraints(userLb,0,0);
        gp.setConstraints(username,1,0);
        gp.setConstraints(passwdLb,0,1);
        gp.setConstraints(passwd,1,1);
        gp.setConstraints(bt,1,2);
        gp.getChildren().addAll(userLb,username,passwdLb,passwd,bt);

        Scene sc=new Scene(gp, 400, 300);
        window.setScene(sc);
        window.show();
    }

    private void printDetails(String username, String passwd)
    {
        System.out.println("USERNAME: "+username+"\nPASSWORD: "+passwd+"\n");
    }
}
