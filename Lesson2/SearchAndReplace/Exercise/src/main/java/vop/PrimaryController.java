package vop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class PrimaryController implements javafx.fxml.Initializable {

    FileChooser file;
    Scanner scanner;
    PrintWriter pw;

    @FXML
    private TextField searchField;

    @FXML
    private TextField replaceField;

    @FXML
    private TextArea textArea;

    @FXML
    private Button replaceBot;

    @FXML
    private Button openFile;

    @FXML
    private Button saveFile;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        file = new FileChooser();
        file.setInitialDirectory(new File("."));
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt");
        file.getExtensionFilters().add(extFilter);
    }

    @FXML
    void openFileMethod(ActionEvent event) {
        File myFile = file.showOpenDialog(new Stage());
        try {
            scanner = new Scanner(myFile);
            while (scanner.hasNextLine()) {
                textArea.appendText(scanner.nextLine() + "\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Wrong path");
        } finally {
            scanner.close();
        }
    }

    @FXML
    void replaceAllFunc(ActionEvent event) {
        scanner = new Scanner(textArea.getText());
        textArea.clear();
        while (scanner.hasNextLine()) {
            textArea.appendText(scanner.nextLine().replaceAll(searchField.getText(), replaceField.getText()) + "\n");
        }
        scanner.close();
    }

    @FXML
    void saveFileMethod(ActionEvent event) {
        File myFile = file.showSaveDialog(new Stage());
        try {
            pw = new PrintWriter(myFile);
            pw.println(textArea.getText());
        } catch (FileNotFoundException | NullPointerException e) {
            System.out.println("Wrong path");
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }
}
