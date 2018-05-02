package scanner.view;

import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.StageStyle;

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

        scan.setOnAction(event -> MainWindow.scan());
        parse.setOnAction(event -> MainWindow.parse());
        compile.setOnAction(event -> MainWindow.compile());

        run.getItems().addAll(scan, parse, compile);

        MenuItem about = new MenuItem("About");

        about.setOnAction(event -> {
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("About");
            alert.setHeaderText(null);
            alert.setContentText("Write, edit, scan, parse, and compile your code!");
            alert.getDialogPane().setStyle("-fx-background-color: #2b2b2b; -fx-base:black;-fx-control-inner-background: #2b2b2b;");
            alert.showAndWait();
        });

        help.getItems().addAll(about);

        getMenus().addAll(file, run, help);

    }
}
