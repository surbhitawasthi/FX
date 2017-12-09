import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.ListView;

public class ListViewDemo extends Application
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
        window.setTitle("List View");

        ListView<String> lv= new ListView<>();
        lv.getItems().addAll("apples","tuna","burger","chowmien","paneer");
        lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        Button bt=new Button("Submit");
        bt.setOnAction(e->
        {
            ObservableList<String> list=lv.getSelectionModel().getSelectedItems();
            for(String str:list)
            {
                System.out.println(str);
            }

        });

        VBox vb=new VBox(10);
        vb.setPadding(new Insets(20,20,20,20));
        vb.getChildren().addAll(lv, bt);

        Scene sc=new Scene(vb, 300, 250);
        window.setScene(sc);
        window.show();
    }
}
