package scanner;

import scanner.controller.Parser;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import scanner.view.MainWindow;
import scanner.model.Dictionary;


public class Main extends Application{

    private static Stage stage;

    public static void main(String[] args) {
	// write your code here
        Parser parser = new Parser("test=test;;\ntest==;test;==;=;\n3{4}\n3344<=4;;54");
        parser.parse();

        System.out.println(Dictionary.getDictionary().getLexemes().get(0).keyword);
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        stage = primaryStage;
        stage.setTitle("Editor");
        Parent root = new MainWindow();
        ScrollPane scrollPane = new ScrollPane(root);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        stage.setScene(new Scene(scrollPane,960,600));
        stage.setFullScreen(true);
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
