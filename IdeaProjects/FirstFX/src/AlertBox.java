import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox
{
    public static void display(String title, String msg)
    {
        Stage window=new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        Label lb=new Label(msg);
        Button bt=new Button("Close");
        bt.setOnAction(e->
        {
            window.close();
            AlertBoxStartingWindow.window.close();
        });

        VBox vb=new VBox(10);
        vb.getChildren().addAll(lb, bt);
        vb.setAlignment(Pos.CENTER);

        Scene sc=new Scene(vb, 250, 200);
        window.setScene(sc);
        window.showAndWait();
    }
}
