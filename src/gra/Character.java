package gra;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Character extends GPars {
    panel panel;
    public int communicate = 0;
    movement playerMovement;
    public Character(panel panel, movement playerMovement) {
        this.panel = panel;
        this.playerMovement = playerMovement;
        loadValues();
        loadImages();
    }
    public void checkObjectCollision() {                    //metoda sprawdza kontakt gracza z obiektami
        if (panel.level == 1) {
            Rectangle characterPos = new Rectangle(X, Y, 50, 50);
            Rectangle object1Pos = new Rectangle(890, 300, 40 - posCorrection, 100 - posCorrection);
            Rectangle object2Pos = new Rectangle(690, 200, 71 - posCorrection, 64 - posCorrection);
            Rectangle object3Pos = new Rectangle(390, 240, 84 - posCorrection, 74 - posCorrection);
            Rectangle object4Pos = new Rectangle(250, 30, 75 - posCorrection, 128 - posCorrection);
            Rectangle object5Pos = new Rectangle(700, 10, 202 - posCorrection, 92 - posCorrection);

            if (characterPos.intersects(object1Pos)) {
                communicate = 1;
            } else if (characterPos.intersects(object2Pos)) {
                communicate = 2;
            } else if (characterPos.intersects(object3Pos)) {
                communicate = 3;
            } else if (characterPos.intersects(object4Pos)) {
                communicate = 4;
            } else if (characterPos.intersects(object5Pos)) {
                playSound(new File("src/sounds/sound.wav"));
                showMessage("CONGRATULATIONS!!!\n YOU HAVE FOUND AN OBJECT YOU WERE LOOKING FOR!\n CLICK 'OK' TO START A NEW LEVEL ");
                itemFound = true;
            } else communicate = 0;
        }
        else if(panel.level == 2){
            Rectangle characterPos = new Rectangle(X, Y, 50, 50);
            Rectangle object6Pos = new Rectangle(600, 180, 90 - posCorrection, 90 - posCorrection);
            Rectangle object7Pos = new Rectangle(350, 459, 48 , 70 );
            Rectangle object8Pos = new Rectangle(250, 440, 50 - posCorrection, 60 );
            Rectangle object9Pos = new Rectangle(200, 160, 100 - posCorrection, 92 - posCorrection);
            Rectangle object10Pos = new Rectangle(860, 25, 63 - posCorrection, 120 - posCorrection);

            if (characterPos.intersects(object6Pos)) {
                communicate = 6;
            } else if (characterPos.intersects(object7Pos)) {
                communicate = 7;
            } else if (characterPos.intersects(object8Pos)) {
                communicate = 8;
            } else if (characterPos.intersects(object9Pos)) {
                communicate = 9;
            } else if (characterPos.intersects(object10Pos)) {
                playSound(new File("src/sounds/sound.wav"));
                showMessage("CONGRATULATIONS!!!\n YOU HAVE FOUND AN OBJECT YOU WERE LOOKING FOR!\n CLICK 'OK' TO START A NEW LEVEL ");
                itemFound = true;
            } else communicate = 0;
        }
        else if(panel.level == 3){
            Rectangle characterPos = new Rectangle(X, Y, 50, 50);
            Rectangle object11Pos = new Rectangle(740, 50, 160 - posCorrection, 130 - posCorrection);
            Rectangle object12Pos = new Rectangle(460, 50, 108 - posCorrection, 108 );
            Rectangle object13Pos = new Rectangle(420, 260, 194 - posCorrection, 148 - posCorrection );
            Rectangle object14Pos = new Rectangle(150, 30, 76 - posCorrection, 122 - posCorrection);
            Rectangle object15Pos = new Rectangle(200, 510, 28 , 28 );

            if (characterPos.intersects(object11Pos)) {
                communicate = 11;
            } else if (characterPos.intersects(object12Pos)) {
                communicate = 12;
            } else if (characterPos.intersects(object13Pos)) {
                communicate = 13;
            } else if (characterPos.intersects(object14Pos)) {
                communicate = 14;
            } else if (characterPos.intersects(object15Pos)) {
                playSound(new File("src/sounds/sound.wav"));
                showMessage("CONGRATULATIONS!!!\n YOU HAVE FOUND LAST OBJECT\n CLICK 'OK' TO RESTART THE GAME ");
                itemFound = true;

            } else communicate = 0;
        }
    }
    private void showMessage(String message) {          //metoda wyswietlajaca komunikat po znalezieniu szukanego obiektu
        JOptionPane.showMessageDialog(panel, message, "WELL DONE", JOptionPane.INFORMATION_MESSAGE);
    }
    public void checkItemFound(){           //metoda sprawdza, czy obiekt zostal znaleziony
        if (itemFound == true) {
            panel.level++;
            itemFound = false;
            X = 524;
            Y = 350;
            if(panel.level == 4){
                panel.level = 1;
            }
        }
    }
    public void CheckMenuOptions(){                     //obsluga menu
        if(playerMovement.c == true){
            System.exit(0);
        }
        if(playerMovement.one == true){
            panel.level = 1;
            X = 524;
            Y = 350;
        }
        if(playerMovement.two == true){
            panel.level = 2;
            X = 524;
            Y = 350;
        }
        if(playerMovement.three == true){
            panel.level = 3;
            X = 524;
            Y = 350;
        }
    }
    public void update() {                              //obluga ruchu gracza
        if (playerMovement.w == true) {
            direction = 'w';
            if(Y > 30){
            Y = Y - 1;
            }
        } else if (playerMovement.s == true) {
            direction = 's';
            if(Y<532){
            Y = Y + 1;
            }
        } else if (playerMovement.a == true) {
            direction = 'a';
            if(X > 76) {
                X = X - 1;
            }
        } else if (playerMovement.d == true) {
            direction = 'd';
            if(X < 858) {
                X = X + 1;
            }
        }

        Counter++;
        if (Counter>20){                            //warunek  zmieniajacy counter i animchanger uzywany ponizej do zmiany animacji podczas ruchu gracza
            if(AnimChanger == true) {
                AnimChanger = false;
            }
            else if(AnimChanger == false){
                AnimChanger = true;
            }
            Counter = 0;
        }
    }

    public void paintComponent(Graphics graph) {            //metoda zmieniajaca animacje postaci podczas ruchu gracza

        BufferedImage image = null;
        switch(direction) {
            case 'w': if(AnimChanger == true)
                image = up1;
                else image = up2;
                break;
            case 's': if(AnimChanger == true)
                image = down1;
                else image = down2;
                break;
            case 'a': if(AnimChanger == true)
                image = left1;
                else image = left2;
                break;
            case 'd': if(AnimChanger == true)
                image = right1;
                else image = right2;
                break;
        }

        graph.drawImage(image, X , Y,100,100,null);


    }
    public static synchronized void playSound(final File f) {           //metoda obslugujaca plik dzwiekowy
        new Thread(new Runnable() {
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(f);
                    clip.open(inputStream);
                    clip.start();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }).start();
    }
}

