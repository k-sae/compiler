package scanner.view;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import java.io.File;

public class NavBar extends MenuBar{

    private Menu file;
    private Menu run;
    private Menu help;

    public NavBar(){

        file = new Menu("File");
        run = new Menu("Run");
        help = new Menu("Help");

        buildMenu();

    }

    private void buildMenu(){

        MenuItem browse = new MenuItem("Browse...");
        MenuItem exit = new MenuItem("Exit");

        browse.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt"));
            File file = fileChooser.showOpenDialog(null);

        });

        exit.setOnAction(event -> System.exit(0));

        file.getItems().addAll(browse, exit);

        MenuItem scan = new MenuItem("Scan");
        MenuItem parse = new MenuItem("Parse");
        MenuItem compile = new MenuItem("Compile");

        run.getItems().addAll(scan, parse, compile);

        MenuItem about = new MenuItem("About");

        help.getItems().addAll(about);

        getMenus().addAll(file, run, help);

    }
}
