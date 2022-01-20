package hwdp;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * klasa ksztaltu malowanych figur
 *  @author  Mateusz Bystronski
 * @author Piotr Korycki
 */
public class MyShape extends Ellipse2D.Double {
    /**
     * kolor
     */
    public Color color;

    /**
     * konstruktor dziedziczacy po ellipse
     * @param x x
     * @param y y
     * @param width szerokosc
     * @param height wysokosc
     */
    public MyShape(double x, double y, double width, double height){
        super(x, y, width, height);
        //this.r = 10;
        //this.b = 70;
        //this.g = 30;




    }

    /**
     * metoda przyporzadkowujaca figurze kolor
     * @param color kolor
     */
    public void setColor(Color color){
        this.color=color;
    }

    /**
     * metoda pobierajaca kolor
     * @return kolor
     */
    public Color getColor(){
        return this.color;
    }
}