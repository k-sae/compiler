package scanner.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ToolBar extends HBox{

    private Button scanBtn;
    private Button parseBtn;
    private Button compileBtn;

    public ToolBar(){

        scanBtn = new Button("Scan");
        parseBtn = new Button("Parse");
        compileBtn = new Button("Compile");

        buildToolBar();

    }

    private void buildToolBar(){

        setAlignment(Pos.CENTER_RIGHT);

        getChildren().addAll(scanBtn, parseBtn, compileBtn);

    }
}
