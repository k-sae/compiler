package scanner.view;

import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;

public class OutputWindow extends StackPane{

    private static TextArea textArea;

    public OutputWindow(){

        textArea = new TextArea();

        buildWindow();

    }
    private void buildWindow(){

        textArea.setWrapText(true);
        textArea.setEditable(false);
        textArea.setStyle("-fx-font-size: 14pt;");
        textArea.setText("OUTPUT\n");

        getChildren().add(textArea);

    }
    public static void setText(String str){

        textArea.setText(str);

    }
    public static void appendText(String str){

        textArea.appendText(str);

    }

}
