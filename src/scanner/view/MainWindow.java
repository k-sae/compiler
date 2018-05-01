package scanner.view;

import javafx.geometry.Pos;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;
import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.*;

public class MainWindow extends VBox {

    private NavBar navBar;
    private ToolBar toolBar;
    private CodeArea codeArea;

    public MainWindow(){

        navBar = new NavBar();
        toolBar = new ToolBar();
        codeArea = new CodeArea();

        setLayout();
    }

    private void setLayout(){
        setAlignment(Pos.TOP_CENTER);
        setSpacing(20);

        codeArea.setParagraphGraphicFactory(LineNumberFactory.get(codeArea));
        codeArea.setStyle("-fx-font-family: Source Code Pro; -fx-font-size: 14pt;");

        getChildren().addAll(navBar, toolBar, new VirtualizedScrollPane<>(codeArea), new Separator());

    }

}