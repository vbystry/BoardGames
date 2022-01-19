package hwdp;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * klasa rozszerzajaca ellipse2d
 * @author  Piotr Korycki
 * @author  Mateusz Bystrosnki
 */
public class MyShape extends Ellipse2D.Double {
    /**
     * wartosci koloru
     */
    private int r, g, b;
    /**
     * kolor
     */
    public Color color;     //zrobic na private

    /**
     * konstruktor dziedziczacy po ellipse oraz przyporzodkowujacy kolor
     * @param x wspolrzedna x
     * @param y wspolrzedna y
     * @param width szerokosc
     * @param height wysokosc
     * @param color kolor
     */
    public MyShape(double x, double y, double width, double height, Color color){
        super(x, y, width, height);
        this.r = 10;
        this.b = 70;
        this.g = 30;
        this.color = color;




    }


}
