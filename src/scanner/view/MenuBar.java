package scanner.view;

import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;

public class MenuBar extends VBox{

    private NavBar navBar;
    private ToolBar toolBar;

    public MenuBar(){

        navBar = new NavBar();
        toolBar = new ToolBar();

        buildMenu();

    }

    private void buildMenu(){

        getChildren().addAll(navBar, toolBar, new Separator());

    }
}
