package scanner.view;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.ArrayList;

public class MainWindow extends StackPane {

    private HBox hBox;
    private VBox numBox;
    private TextArea textArea;

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

    private void highlightLine(ArrayList<Integer> lines){

        for (int line:lines){
            numBox.getChildren().get(line+1).setStyle("-fx-background-color: red;");
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

}