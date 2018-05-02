package scanner.view;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import scanner.controller.Optimizer;
import scanner.controller.Parser;
import scanner.model.ScannerOutput;

import java.util.ArrayList;

public class MainWindow extends StackPane {

    private HBox hBox;
    private static VBox numBox;
    private static TextArea textArea;

    public MainWindow(){

        hBox = new HBox();
        numBox = new VBox();
        textArea = new TextArea();

        setLayout();
    }

    private void setLayout(){
        setPadding(new Insets(10, 0, 10, 0));

        numBox.setSpacing(5);
        numBox.setPadding(new Insets(10));
        Label label = new Label("" + 1);
        label.setFont(Font.font(15));
        numBox.getChildren().add(label);

        textArea.setStyle("-fx-font-family: Source Code Pro; -fx-font-size: 14pt;");

        textArea.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {

                while (lineCounts(textArea.getText()) > numBox.getChildren().size()) {
                    Label label = new Label("" + (numBox.getChildren().size() + 1));
                    label.setFont(Font.font(15));
                    label.setWrapText(true);
                    if(Integer.parseInt(label.getText()) >= 10)
                        label.setMinWidth(25);
                    numBox.getChildren().add(label);
                }

                while (lineCounts(textArea.getText()) < numBox.getChildren().size())
                    numBox.getChildren().remove(numBox.getChildren().size() - 1);

            }
        });

        HBox.setHgrow(textArea, Priority.ALWAYS);
        hBox.getChildren().addAll(numBox, textArea);
        getChildren().addAll(hBox);

    }

    private static void highlightLine(int line){

        numBox.getChildren().get(line-1).setStyle("-fx-background-color: red;");

    }
    private static void removeHighlight(){

        for (Node node:numBox.getChildren()) {
            node.setStyle(null);
        }

    }
    private int lineCounts(String str){

        int lineCount = 1;

        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == '\n') {
                ++lineCount;
            }
        }
        return lineCount;
    }

    public static void scan(){
        removeHighlight();
        Parser parser = new Parser(new Optimizer().Optimize(textArea.getText()));
        ArrayList<ScannerOutput> scannerOutputs =  parser.parse();
        for (ScannerOutput scannerOutput: scannerOutputs) {
            System.out.println(scannerOutput.lexeme +  ":\t" + scannerOutput.token + "\tLine: " + scannerOutput.lineNo);
            if(scannerOutput.token.equals("Error")){
                highlightLine(scannerOutput.lineNo);
            }
        }
    }

}