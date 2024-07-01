package gra;

import javax.swing.*;
import java.awt.*;

public class panel extends JPanel implements Runnable {
    int gameWidth = 1048;
    int gameHeight = 700;
    public int level = 1;
    private Font textFont = new Font("Arial", Font.BOLD, 36);
    private GPars gpars;
    movement playerMovement = new movement();
    Thread thread;
    Character character = new Character(this,playerMovement);

    public panel() {
        this.setPreferredSize(new Dimension(gameWidth,gameHeight));
        this.setBackground(Color.white);
        this.addKeyListener(playerMovement);
        this.setFocusable(true);
        gpars = new GPars();
    }
    public void startGameThread(){
        thread = new Thread();
        thread.start();
    }


    @Override
    public void run() {                         //uruchomienie watku
        double paintBreak = 15000000; //15ms

        while(thread != null) {                     //petla aktualizujaca i wyswietlajaca obraz co 15ms
            update();
            repaint();
            try{
                double paintBreakInMs = paintBreak/1000000;
            Thread.sleep((long)paintBreakInMs);
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void update() {              //metoda aktualizujaca polozenie gracza, sprawdzajaca warunki
        character.update();
        character.checkObjectCollision();
        character.checkItemFound();
        character.CheckMenuOptions();
    }
    public void drawMenu(Graphics graph) {                      //metoda rysujaca menu
            graph.setColor(Color.darkGray);
            graph.fillRect(900, 530, 148, 200);
            graph.setColor(Color.WHITE);
            graph.setFont(new Font("Arial", Font.BOLD, 20));
            graph.drawString("MENU ", 944, 558);
            graph.drawString("close - 'c'", 932, 600);
            graph.drawString("level 1 - '1'", 932, 620);
            graph.drawString("level 2 - '2'", 932, 640);
            graph.drawString("level 3 - '3'", 932, 660);
    }

    public void paintComponent(Graphics graph) {  //metoda rysujaca tlo, elementy i komunikaty w zaleznosci od poziomu rozgrywki
        super.paintComponent(graph);

        switch (level) {
            case 1:
                graph.drawImage(gpars.background1, 0, 0, gameWidth, gameHeight, null);
                graph.drawImage(gpars.obj1,890,300,40,100,null);
                graph.drawImage(gpars.obj2,690,200,71,64,null);
                graph.drawImage(gpars.obj3,390,240,84,74,null);
                graph.drawImage(gpars.obj4,250,30,75,128,null);
                graph.drawImage(gpars.obj5,700,10,202,92,null);
                graph.setColor(Color.white);
                graph.setFont(textFont);
                graph.drawString("LEVEL 1: FIND A PAINTING", 280, 30);
                if(character.communicate == 1){
                    graph.drawString("This is not painting, this is a door mat", 240, 430);
                }
                else if(character.communicate == 2){
                    graph.drawString("This is not painting, this is a cat", 240, 430);
                }
                else if(character.communicate == 3){
                    graph.drawString("This is not painting, these are fruits", 240, 430);
                }
                else if(character.communicate == 4){
                    graph.drawString("This is not painting, this is a chair", 240, 430);
                }


                break;
            case 2:
                graph.drawImage(gpars.background2, 0, 0, gameWidth, gameHeight, null);
                graph.drawImage(gpars.obj6,600,180,90,90,null);
                graph.drawImage(gpars.obj7,350,450,48,33,null);
                graph.drawImage(gpars.obj8,250,440,50,60,null);
                graph.drawImage(gpars.obj9,200,160,100,92,null);
                graph.drawImage(gpars.obj10,860,25,63,120,null);
                graph.setColor(Color.white);
                graph.setFont(textFont);
                graph.drawString("LEVEL 2: FIND A SHOVEL", 280, 30);
                if(character.communicate == 6){
                    graph.drawString("This is not shovel, this is a dog", 240, 430);
                }
                else if(character.communicate == 7){
                    graph.drawString("This is not shovel, this is a watering can", 240, 430);
                }
                else if(character.communicate == 8){
                    graph.drawString("This is not shovel, these are flowers", 240, 430);
                }
                else if(character.communicate == 9){
                    graph.drawString("This is not shovel, these are rakes", 240, 430);
                }


                break;
            case 3:
                graph.drawImage(gpars.background3, 0, 0, gameWidth, gameHeight, null);
                graph.drawImage(gpars.obj11,740,50,160,160,null);
                graph.drawImage(gpars.obj12,460,50,108,108,null);
                graph.drawImage(gpars.obj13,420,260,194,148,null);
                graph.drawImage(gpars.obj14,150,30,76,122,null);
                graph.drawImage(gpars.obj15,200,510,48,48,null);
                graph.setColor(Color.white);
                graph.setFont(textFont);
                graph.drawString("LEVEL 3: FIND A BUCKET", 280, 30);
                if(character.communicate == 11){
                    graph.drawString("This is not bucket, this is a bath", 240, 430);
                }
                else if(character.communicate == 12){
                    graph.drawString("This is not bucket, this is a washing machine", 240, 430);
                }
                else if(character.communicate == 13){
                    graph.drawString("This is not bucket, this a is carpet", 240, 430);
                }
                else if(character.communicate == 14) {
                    graph.drawString("This is not bucket, this is a toilet", 240, 430);
                }
                break;

            default:
                graph.setColor(Color.white);
                graph.fillRect(0, 0, gameWidth, gameHeight);
                break;
        }
        character.paintComponent(graph);
        drawMenu(graph);
    }
}
