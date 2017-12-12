import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
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
    TextField nameField, priceField, quantityField;
    Button add,del;

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

        nameField = new TextField();
        nameField.setPromptText("Name of product");
        nameField.setMinWidth(100);

        priceField = new TextField();
        priceField.setPromptText("Price of product");
        priceField.setMinWidth(100);

        quantityField = new TextField();
        quantityField.setPromptText("Quantity of product");
        quantityField.setMinWidth(100);

        add=new Button("Add");
        del=new Button("Delete");

        add.setOnAction(e->addButton());
        del.setOnAction(e->delButton());

        HBox hb=new HBox(10);
        hb.setPadding(new Insets(20,20,20,20));
        hb.getChildren().addAll(nameField, priceField, quantityField, add, del);

        VBox vb=new VBox();
        vb.getChildren().addAll(table,hb);

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

    public void addButton()
    {
        int price,quantity;
        String name=nameField.getText();
        try
        {
            price = Integer.parseInt(priceField.getText());
            quantity = Integer.parseInt(quantityField.getText());

            TableProductClass product = new TableProductClass();
            product.setName(name);
            product.setPrice(price);
            product.setQuantity(quantity);

            table.getItems().add(product);
            nameField.clear();
            priceField.clear();
            quantityField.clear();
        }
        catch (Exception e)
        {
            AlertBox.display("Hey bro what are you doing","Not a number in price or quantity field");
        }

    }

    public void delButton()
    {
        ObservableList<TableProductClass> allProducts, selectedProducts;
        allProducts=table.getItems();
        selectedProducts=table.getSelectionModel().getSelectedItems();

        selectedProducts.forEach(allProducts::remove);
    }
}
