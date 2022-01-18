package hwdp;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class MyShape extends Ellipse2D.Double {
    public Color color;
    public MyShape(double x, double y, double width, double height){
        super(x, y, width, height);
        //this.r = 10;
        //this.b = 70;
        //this.g = 30;




    }

    public void setColor(Color color){
        this.color=color;
    }
}