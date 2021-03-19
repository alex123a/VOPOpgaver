package vop;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class PrimaryController implements Initializable, CallBackInterface {

    @FXML
    private TextArea textArea;
    @FXML
    private Button startButton;
    @FXML
    private Button stopButton;
    @FXML
    private ImageView die1view;
    @FXML
    private ImageView die2view;

    private FacadeWithCallback facade;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        startButton.setDisable(false);
        stopButton.setDisable(true);
    }

    @FXML
    private void buttonAction(ActionEvent event) {
        try {
            if (event.getSource() == startButton) {
                facade = new FacadeWithCallback(this);
                facade.setDaemon(true);
                facade.start();
                stopButton.setDisable(false);
                startButton.setDisable(true);
            } else {
                facade.interrupt();
                stopButton.setDisable(true);
                startButton.setDisable(false);
            }
        } catch (URISyntaxException e) {

        }
    }

    @Override
    public void updateMessage(String message) {
        if (facade != null && facade.isAlive()) {
            textArea.appendText(message);
        }
    }

    @Override
    public void updateImages(File i1, File i2) {
        try {
            if (facade != null && facade.isAlive()) {
                die1view.setImage(new Image(getClass().getResource(i1.getName()).toURI().toString()));
                die2view.setImage(new Image(getClass().getResource(i2.getName()).toURI().toString()));
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stopped() {
        stopButton.setDisable(true);
        startButton.setDisable(false);
    }
}