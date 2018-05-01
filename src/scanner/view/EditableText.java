package scanner.view;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import org.fxmisc.richtext.*;

public class EditableText extends HBox{

    private VBox numBox;
    private TextArea textArea;

    public EditableText(){

        numBox = new VBox();
        textArea = new TextArea();

        buildEditableText();

    }

    private void buildEditableText(){

        setSpacing(5);
        setFillHeight(true);

        numBox.setSpacing(5);
        numBox.setPadding(new Insets(5));
        numBox.getChildren().add(new Label("" + 1));


        textArea.setWrapText(true);
        textArea.setMinSize(1920, 1080);
        textArea.setFont(Font.font("Source Code Pro", 17));

        textArea.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.ENTER) {

                    Label label = new Label("" + (numBox.getChildren().size() + 1));
                    label.setWrapText(true);
                    if(Integer.parseInt(label.getText()) >= 10)
                        label.setMinWidth(25);
                    numBox.getChildren().add(label);

                }else if(keyEvent.getCode() == KeyCode.BACK_SPACE){
                    if(numBox.getChildren().size() > 1) {
                        numBox.getChildren().remove(numBox.getChildren().size() - 1);
                    }
                }
            }
        });


        getChildren().addAll(numBox, textArea);
    }

}
