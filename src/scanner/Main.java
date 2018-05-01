package scanner;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import scanner.view.MainWindow;
import scanner.view.MenuBar;
import scanner.view.ResultWindow;
import scanner.model.Dictionary;


public class Main extends Application{

    private static Stage stage;
    private static BorderPane borderPane;

    public static void main(String[] args) {

        System.out.println(Dictionary.getDictionary().getLexemes().get(0).keyword);
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        stage = primaryStage;
        stage.setTitle("Editor");

        MenuBar menuBar = new MenuBar();
        MainWindow mainWindow = new MainWindow();
        ResultWindow resultWindow = new ResultWindow();

        borderPane = new BorderPane();
        borderPane.setTop(menuBar);
        borderPane.setCenter(mainWindow);
        borderPane.setBottom(resultWindow);

        stage.setScene(new Scene(borderPane,960,600));
        stage.setMaximized(true);
        // stage.getIcons().add(new Image("file:img/icon.jpg"));
        stage.show();

    }
    public static void navigateTo (Parent node){

        ScrollPane scrollPane = new ScrollPane(node);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        stage.setScene(new Scene(scrollPane,960,600));

    }
}
