package hwdp;

import java.awt.geom.Ellipse2D;

public class ChineseCheckersPawn extends Pawn{
    private int pawndiameter = 27;
    public ChineseCheckersPawn(int[] coords, double coordx, double coordy){
        super();
        position = coords;
        shape = new MyShape(coordx, coordy, pawndiameter, pawndiameter);
    }
}
