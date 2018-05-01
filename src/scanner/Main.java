package scanner;

import scanner.controller.Optimizer;
import scanner.controller.Parser;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import scanner.model.ScannerOutput;
import scanner.view.MainWindow;
import scanner.model.Dictionary;

import java.util.ArrayList;


public class Main extends Application{

    private static Stage stage;

    public static void main(String[] args) {
	// write your code here
        Parser parser = new Parser(new Optimizer().Optimize("<^ test comment\n" +
                "\n" +
                "continue\n" +
                "^>test\n" +
                "^^line comment 1\n" +
                "5test=test;;_test==;test;==;=;/3{4}/3344<=4;;54 ^^ line comment 2"));
        ArrayList<ScannerOutput> scannerOutputs =  parser.parse();
        for (ScannerOutput scannerOutput: scannerOutputs
             ) {
            System.out.println(scannerOutput.lexeme +  ":\t" + scannerOutput.token + "\tLine: " + scannerOutput.lineNo);
        }
//        System.exit(0);
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
