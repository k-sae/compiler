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
        numBox.setPadding(new Insets(5));
        numBox.getChildren().add(new Label("" + 1));

        textArea.setStyle("-fx-font-family: Source Code Pro; -fx-font-size: 14pt;");

        textArea.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                System.out.println(textArea.getText().split("\n").length);
                if (keyEvent.getCode() == KeyCode.ENTER) {

                    Label label = new Label("" + (numBox.getChildren().size() + 1));
                    label.setWrapText(true);
                    if(Integer.parseInt(label.getText()) >= 10)
                        label.setMinWidth(25);
                    numBox.getChildren().add(label);

                }else if(keyEvent.getCode() == KeyCode.BACK_SPACE){
                    if(numBox.getChildren().size() > 1) {
                        numBox.getChildren().remove(numBox.getChildren().size() - 1);
                    }
                }
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

}