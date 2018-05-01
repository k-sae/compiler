package scanner.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;

public class MainWindow extends StackPane {

    private TextArea textArea;

    public MainWindow(){

        textArea = new TextArea();

        setLayout();
    }

    private void setLayout(){
        setAlignment(Pos.CENTER);
        setPadding(new Insets(10, 0, 10, 0));

        textArea.setStyle("-fx-font-family: Source Code Pro; -fx-font-size: 14pt;");

        getChildren().addAll(textArea);

    }

}