import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuBarDemmo extends Application
{
    public static void main(String args[])
    {
        launch(args);
    }

    Stage window;
    BorderPane bp;
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        window=primaryStage;
        window.setTitle("Menu Bar");

        //File Menu
        Menu fileMenu=new Menu("_File");
        //File Menu Items
        fileMenu.getItems().add(new MenuItem("New..."));
        fileMenu.getItems().add(new MenuItem("Open..."));
        fileMenu.getItems().add(new MenuItem("Save..."));
        fileMenu.getItems().add(new SeparatorMenuItem());
        MenuItem setting = new MenuItem("Setting...");
        setting.setDisable(true);
        fileMenu.getItems().add(setting);
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Exit"));

        Menu editMenu = new Menu("_Edit");
        editMenu.getItems().add(new MenuItem("Cut"));
        editMenu.getItems().add(new MenuItem("Copy"));
        editMenu.getItems().add(new MenuItem("Paste"));
        editMenu.getItems().add(new SeparatorMenuItem());
        editMenu.getItems().add(new MenuItem("Find & Replace"));

        Menu helpMenu=new Menu("Help");
        CheckMenuItem lineNumber=new CheckMenuItem("Show line number");
        lineNumber.setOnAction(e->
        {
            if(lineNumber.isSelected())
                System.out.println("1 Selected");
            else
                System.out.println("1 Not Selected");
        });
        helpMenu.getItems().add(lineNumber);
        CheckMenuItem autoSave=new CheckMenuItem("AutoSave");
        autoSave.setOnAction(e->
        {
            if(autoSave.isSelected())
                System.out.println("2 Selected");
            else
                System.out.println("2 Not Selected");
        });
        autoSave.setSelected(true);
        helpMenu.getItems().add(autoSave);

        //Difficulty menu item
        Menu difficultyMenu=new Menu("Difficulty");
        ToggleGroup diffTog=new ToggleGroup();

        RadioMenuItem easy=new RadioMenuItem("Easy");
        RadioMenuItem medium=new RadioMenuItem("Medium");
        RadioMenuItem hard=new RadioMenuItem("Hard");

        easy.setToggleGroup(diffTog);
        medium.setToggleGroup(diffTog);
        hard.setToggleGroup(diffTog);

        difficultyMenu.getItems().addAll(easy, medium, hard);

        //Main Menu Bar
        MenuBar mb=new MenuBar();
        mb.getMenus().add(fileMenu);
        mb.getMenus().add(editMenu);
        mb.getMenus().add(helpMenu);
        mb.getMenus().add(difficultyMenu);

        bp=new BorderPane();
        bp.setTop(mb);
        Scene sc=new Scene(bp,400,300);
        window.setScene(sc);
        window.show();
    }
}
