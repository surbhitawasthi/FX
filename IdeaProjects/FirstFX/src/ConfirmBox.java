import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox
{
    static boolean ans;
    public static boolean display(String title, String msg)
    {
        Stage window=new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        Label lb=new Label(msg);

        Button yBt=new Button("Yes");
        Button nBt=new Button("No");

        yBt.setOnAction(e ->
        {
            ans = true;
            window.close();
        });
        nBt.setOnAction(e ->
        {
            ans = false;
            window.close();
        });


        VBox vb=new VBox(10);
        vb.getChildren().addAll(lb, yBt, nBt);
        vb.setAlignment(Pos.CENTER);
        Scene sc=new Scene(vb, 250, 200);
        window.setScene(sc);
        window.showAndWait();

        return ans;
    }
}
