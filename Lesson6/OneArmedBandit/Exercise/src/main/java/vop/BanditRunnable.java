package vop;

import javafx.scene.image.ImageView;

public class BanditRunnable implements Runnable {

    private int i; //Index of current picture
    private long sleepTime;
    private boolean running = true;
    private ImageView iw;

    public BanditRunnable(int i, long sleepTime, ImageView iw)   {
        this.i = i;
        this.sleepTime = sleepTime;
        this.iw = iw;
    }

    @Override
    public void run() {
        try {
            PrimaryController.countUp();
            while (running) {
                System.out.println(i);
                iw.setImage(PrimaryController.image[i % 10]);
                i++;
                Thread.sleep(sleepTime);
            }
        } catch (InterruptedException e) {

        }
    }
}
