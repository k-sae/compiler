package scanner.view;

import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;

public class MainWindow extends VBox {

    private NavBar navBar;
    private ToolBar toolBar;
    private EditableText editableText;
    private ScrollPane scrollPane;

    public MainWindow(){

        navBar = new NavBar();
        toolBar = new ToolBar();
        editableText = new EditableText();
        scrollPane = new ScrollPane(editableText);

        setLayout();
    }

    private void setLayout(){
        setAlignment(Pos.TOP_CENTER);
        setSpacing(20);

        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        getChildren().addAll(navBar, toolBar, scrollPane, new Separator());

    }

}