package scanner.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.*;

public class MainWindow extends StackPane {

    private CodeArea codeArea;

    public MainWindow(){

        codeArea = new CodeArea();

        setLayout();
    }

    private void setLayout(){
        setAlignment(Pos.CENTER);
        setPadding(new Insets(10, 0, 10, 0));

        codeArea.setParagraphGraphicFactory(LineNumberFactory.get(codeArea));
        codeArea.setStyle("-fx-font-family: Source Code Pro; -fx-font-size: 14pt;");

        getChildren().addAll(new VirtualizedScrollPane<>(codeArea));

    }

}