package hwdp;

import java.awt.geom.Ellipse2D;

public class MyShape extends Ellipse2D.Double {
    private int r, g, b;
    public MyShape(double x, double y, double width, double height){
        super(x, y, width, height);
        this.r = 10;
        this.b = 70;
        this.g = 30;




    }
}
