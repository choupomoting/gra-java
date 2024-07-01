package gra;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.image.BufferedImage;

public class GPars {
    public int X, Y;            //wspolrzedne gracza
    public char direction;      //kierunek poruszania sie gracza
    public int Counter = 0;                 //zmienne pomocnicze do zmiany animacji
    public boolean AnimChanger = true;
    public BufferedImage left1, left2, right1, right2, up1, up2, down1, down2;          //assety postaci
    public BufferedImage background1, background2, background3;                         //tla gry dla poziomow
    public BufferedImage obj1,obj2,obj3,obj4,obj5,obj6,obj7,obj8,obj9,obj10,obj11,obj12,obj13,obj14,obj15;      //obiekty

    public boolean itemFound = false;
    public int posCorrection = 30;

    public GPars() {            //wywolanie metod ladujacych obrazki
        loadBackgrounds();
        loadObjects();
    }

    public void loadBackgrounds() {         // metody ladujace uzywane w grze tla i assety
        try {
            background1 = ImageIO.read(getClass().getResourceAsStream("/images/background1.png"));
            background2 = ImageIO.read(getClass().getResourceAsStream("/images/background2.png"));
            background3 = ImageIO.read(getClass().getResourceAsStream("/images/background3.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadObjects() {
        try {
            obj1 = ImageIO.read(getClass().getResourceAsStream("/images/doormat.png"));
            obj2 = ImageIO.read(getClass().getResourceAsStream("/images/cat.png"));
            obj3 = ImageIO.read(getClass().getResourceAsStream("/images/fruits.png"));
            obj4 = ImageIO.read(getClass().getResourceAsStream("/images/chair.png"));
            obj5 = ImageIO.read(getClass().getResourceAsStream("/images/painting.png"));
            obj6 = ImageIO.read(getClass().getResourceAsStream("/images/dog.png"));
            obj7 = ImageIO.read(getClass().getResourceAsStream("/images/wateringcan.png"));
            obj8 = ImageIO.read(getClass().getResourceAsStream("/images/flower.png"));
            obj9 = ImageIO.read(getClass().getResourceAsStream("/images/rakes.png"));
            obj10 = ImageIO.read(getClass().getResourceAsStream("/images/shovel.png"));
            obj11 = ImageIO.read(getClass().getResourceAsStream("/images/bath.png"));
            obj12 = ImageIO.read(getClass().getResourceAsStream("/images/wmach.png"));
            obj13 = ImageIO.read(getClass().getResourceAsStream("/images/carpet.png"));
            obj14 = ImageIO.read(getClass().getResourceAsStream("/images/toilet.png"));
            obj15 = ImageIO.read(getClass().getResourceAsStream("/images/bucket.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadImages() {
        try {
            left1 = ImageIO.read(getClass().getResourceAsStream("/images/lewo1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/images/lewo2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/images/prawo1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/images/prawo2.png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("/images/gora1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/images/gora2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/images/dol1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/images/dol2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadValues() {  //zaladowanie wspolrzednych gracza
        direction = 'd';
        X = 524;
        Y = 350;
    }
}
