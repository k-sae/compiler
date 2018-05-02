package scanner.view;

import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;

public class ResultWindow extends StackPane{

    private TextArea textArea;

    public ResultWindow(){

        textArea = new TextArea();

        buildWindow();

    }
    private void buildWindow(){

        textArea.setWrapText(true);
        textArea.setEditable(false);
        textArea.setStyle("-fx-font-size: 14pt;");
        textArea.setText("OUTPUT");

        getChildren().add(textArea);

    }

}
