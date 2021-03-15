package vop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrimaryController implements Initializable  {

    @FXML
    private ImageView slot1;

    @FXML
    private ImageView slot2;

    @FXML
    private ImageView slot3;

    @FXML
    private Button startBut;

    @FXML
    private Button slot1But;

    @FXML
    private Button slot2But;

    @FXML
    private Button slot3But;

    @FXML
    private Label resultLabel;

    protected static Image[] image = new Image[10];

    private static int threadsRunning = 0;

    private Thread thread1;
    private Thread thread2;
    private Thread thread3;

    public static synchronized void countUp() {
        threadsRunning++;
    }

    public static synchronized void countDown() {
        threadsRunning--;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (int i = 0; i < 10; i++) {
            try {
                image[i] = new Image(getClass().getResource("fruits" + i + ".png").toURI().toString());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void start(ActionEvent event) {
        resultLabel.setText("Running");
        thread1 = new Thread(new BanditRunnable(3, 100, slot1));
        thread2 = new Thread(new BanditRunnable(5, 120, slot2));
        thread3 = new Thread(new BanditRunnable(7, 130, slot3));
        thread1.setDaemon(true);
        thread2.setDaemon(true);
        thread3.setDaemon(true);
        thread1.start();
        thread2.start();
        thread3.start();
        startBut.setDisable(true);
        slot1But.setDisable(false);
        slot2But.setDisable(false);
        slot3But.setDisable(false);
    }

    @FXML
    public void stop(ActionEvent event) {
        countDown();
        if (event.getSource() == slot1But) {
            thread1.interrupt();
            slot1But.setDisable(true);
        } else if (event.getSource() == slot2But) {
            thread2.interrupt();
            slot2But.setDisable(true);
        } else if (event.getSource() == slot3But){
            thread3.interrupt();
            slot3But.setDisable(true);
        }

        if (threadsRunning == 0) {
            startBut.setDisable(false);
            if (slot1.getImage().equals(slot2.getImage()) && slot2.getImage().equals(slot3.getImage())) {
                resultLabel.setText("Jackpot!");
            } else if (slot1.getImage().equals(slot2.getImage()) || slot2.getImage().equals(slot3.getImage()) || slot1.getImage().equals(slot3.getImage())) {
                resultLabel.setText("Du vinder lidt");
            } else {
                resultLabel.setText("TABER!!!");
            }
            resultLabel.setDisable(false);
        }
    }
}

