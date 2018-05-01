package scanner.view;

import javafx.scene.layout.StackPane;
import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.*;

public class ResultWindow extends StackPane{

    private CodeArea textArea;

    public ResultWindow(){

        textArea = new CodeArea();

        buildWindow();

    }
    private void buildWindow(){

        textArea.setWrapText(true);
        textArea.setEditable(false);
        textArea.setStyle("-fx-font-size: 14pt;");
        textArea.replaceText("OUTPUT");

        getChildren().add(new VirtualizedScrollPane<>(textArea));

    }

}
