package vop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;

public class PrimaryController implements Initializable {

    @FXML
    private TextField searchField;
    @FXML
    private TextField replaceField;
    @FXML
    private TextArea textArea;
    @FXML
    private Button replaceAllButton;
    @FXML
    private Button openFileButton;
    @FXML
    private Button saveAsButton;

    private FileChooser fileChooser;
    private IoFacade facade;


    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void replaceButtonHandler(ActionEvent event) {
        String searchText = searchField.getText();
        String replaceText = replaceField.getText();
        String originalText = textArea.getText();
        String newText = originalText.replaceAll(searchText, replaceText);
        textArea.setText(newText);
        Collections c;
    }

    @FXML
    private void openFileHandler(ActionEvent event) {
        textArea.clear();
        File inFile = fileChooser.showOpenDialog(textArea.getScene().getWindow());
        if (inFile == null)
            return;

        String txt = facade.readFile(inFile);
        textArea.setText(txt);
    }

    @FXML
    private void saveAsFileHandler(ActionEvent event) {
        File outFile = fileChooser.showSaveDialog(textArea.getScene().getWindow());
        if (outFile == null)
            return;


        facade.writeFile(textArea.getText(), outFile);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("."));// Working directory
        facade = new IoFacade();
    }
}
