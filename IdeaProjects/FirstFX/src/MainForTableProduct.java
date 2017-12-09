import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainForTableProduct extends Application
{
    public static void main(String args[])
    {
        launch(args);
    }

    Stage window;
    TableView<TableProductClass> table;
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        window = primaryStage;
        window.setTitle("Table View");

        //Name Column
        TableColumn<TableProductClass, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        //joining of columns to our product names;
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //Price Column
        TableColumn<TableProductClass, Integer> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(100);
        //joining of columns to our product price;
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        //Quantity Column
        TableColumn<TableProductClass, Integer> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(100);
        //joining of columns to our product names;
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        table = new TableView<>();
        table.setItems(getTableProductClass());
        table.getColumns().addAll(nameColumn, priceColumn, quantityColumn);

        VBox vb=new VBox();
        vb.getChildren().addAll(table);

        Scene sc=new Scene(vb);
        window.setScene(sc);
        window.show();
    }

    //function that returns an Observablelist type object
    public ObservableList<TableProductClass> getTableProductClass()
    {
        ObservableList<TableProductClass> products = FXCollections.observableArrayList();

        products.add(new TableProductClass("laptops", 53000, 20));
        products.add(new TableProductClass("balls", 150, 124));
        products.add(new TableProductClass("Maps", 99, 5));
        products.add(new TableProductClass("Paneer", 340, 22));

        return products;

    }
}
