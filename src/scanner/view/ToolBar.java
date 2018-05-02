package scanner.view;

import javafx.geometry.Insets;
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

        setSpacing(5);
        setAlignment(Pos.CENTER_RIGHT);
        setPadding(new Insets(10));

        scanBtn.setOnAction(event -> MainWindow.scan());

        getChildren().addAll(scanBtn, parseBtn, compileBtn);

    }
}
