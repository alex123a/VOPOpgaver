/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vop;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


import java.io.File;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author fsan
 */
public class FacadeWithCallbackTest {

    FacadeWithCallback facade;
    CallBackInterface soutCallBack;
    Dice dice;

    public FacadeWithCallbackTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {

    }

    @Before
    public void setUp() {
//        TODO
//        Instantiate your CallBackInterface
//        Instantiate and start your Facade Thread
        soutCallBack = new CallBackInterface() {
            @Override
            public void updateMessage(String message) {

            }

            @Override
            public void updateImages(File i1, File i2) {

            }
        };
        try {
            facade = new FacadeWithCallback(soutCallBack);
            facade.setDaemon(true);
            facade.start();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }

    @After
    public void tearDown() {
//        TODO
//        Interrupt your facade Thread
        facade.interrupt();
    }

    /**
     * Test of run method, of class FacadeWithCallback.
     */

    @Test
    public void testRun() {
//        TODO
//        Test the run() method
//        Assert if the dice.getDie1() and dice.getDie2() are equal to integer 6
        try {
            facade.join();
            assertEquals(facade.getDice().getDie1(), 6);
            assertEquals(facade.getDice().getDie2(), 6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
