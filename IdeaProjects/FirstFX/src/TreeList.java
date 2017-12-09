import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TreeList extends Application
{
    public static void main(String args[])
    {
        launch(args);
    }

    Stage window;
    TreeView<String> treeView;
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        window = primaryStage;
        window.setTitle("Tree view");

        TreeItem<String> root, first,second;

        root=new TreeItem<>();
        //root.setExpanded(true);

        first=makeChild("first", root);
        makeChild("paneer", first);
        makeChild("corn", first);
        makeChild("cheese", first);

        second=makeChild("second", root);
        makeChild("paneer", second);
        makeChild("corn", second);
        makeChild("third", root);

        treeView = new TreeView<>(root);
        treeView.setShowRoot(false);
        treeView.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue)->
        {
            System.out.println(newValue.getValue());
        });

        StackPane sp=new StackPane();
        sp.getChildren().addAll(treeView);
        Scene sc=new Scene(sp, 300, 250);
        window.setScene(sc);
        window.show();
    }

    private static TreeItem<String> makeChild(String child, TreeItem<String> par)
    {
        TreeItem<String> item = new TreeItem<>(child);
        //item.setExpanded(true);
        par.getChildren().add(item);
        return item;
    }
}
