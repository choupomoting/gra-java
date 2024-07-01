package gra;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class movement implements KeyListener {                  //klasa obslugujaca poruszanie sie postaci i opcje menu wybierane z klawiatury
    public boolean w,a,s,d,c,one,two,three;
    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {                        //metoda obslugujaca klawiature, gdy przycisk jest wciskany
        int key = e.getKeyCode();
        if ( key == KeyEvent.VK_A){
            a=true;
        }
        if ( key == KeyEvent.VK_D){
            d=true;
        }
        if ( key == KeyEvent.VK_W){
            w=true;
        }
        if ( key == KeyEvent.VK_S){
            s=true;
        }
        if (key == KeyEvent.VK_C){
            c=true;
        }
        if (key == KeyEvent.VK_1){
            one=true;
        }
        if (key == KeyEvent.VK_2){
            two=true;
        }
        if (key == KeyEvent.VK_3){
            three=true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {                   //metoda obslugujaca klawiature, gdy przycisk jest puszczany
        int key = e.getKeyCode();
        if ( key == KeyEvent.VK_A){
            a=false;
        }
        if ( key == KeyEvent.VK_D){
            d=false;
        }
        if ( key == KeyEvent.VK_W){
            w=false;
        }
        if ( key == KeyEvent.VK_S){
            s=false;
        }
        if (key == KeyEvent.VK_1){
            one=false;
        }
        if (key == KeyEvent.VK_2){
            two=false;
        }
        if (key == KeyEvent.VK_3){
            three=false;
        }
    }
}
