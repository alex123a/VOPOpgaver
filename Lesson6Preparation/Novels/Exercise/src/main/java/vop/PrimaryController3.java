package vop;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ResourceBundle;

public class PrimaryController3 implements Initializable {

    @FXML
    private Label funLabel;
    private String text;
    private int speedVar = 200;


    @FXML
    private Button startBut;

    @FXML
    private Button stopBut;

    @FXML
    private RadioButton speed100;

    @FXML
    private RadioButton speed200;

    @FXML
    private RadioButton speed400;

    @FXML
    private ToggleGroup speed;

    @FXML
    void startThread(ActionEvent event) {
        if (!thread.isAlive()) {
            thread = newThread();
            thread.setDaemon(true);
            thread.start();
        }
    }

    @FXML
    void stopThread(ActionEvent event) {
        thread.interrupt();
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        thread.setDaemon(true);
        thread.start();
    }

    @FXML
    void speedHandler(ActionEvent event) {
        if (speed100.isSelected()) {
            speedVar = 100;
        } else if (speed200.isSelected()) {
            speedVar = 200;
        } else if (speed400.isSelected()) {
            speedVar = 400;
        }
    }

    public Thread newThread() {
        return new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        if (funLabel.getText().trim().length() == 0) {
                            text = "Programming is fun";
                        } else {
                            text = "";
                        }
                        System.out.println("Flash: " + text);
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                funLabel.setText(text);
                            }
                        });

                        Thread.sleep(speedVar);
                    }
                } catch (InterruptedException ex) {
                }

            }

        });
    }

    private Thread thread = newThread();
}
