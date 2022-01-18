package hwdp;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class MyShape extends Ellipse2D.Double {
    private int r, g, b;
    public Color color;     //zrobic na private
    public MyShape(double x, double y, double width, double height, Color color){
        super(x, y, width, height);
        this.r = 10;
        this.b = 70;
        this.g = 30;
        this.color = color;




    }


}
