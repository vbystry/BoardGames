package hwdp;

import java.awt.geom.Ellipse2D;

public class ChineseCheckersPawn extends Pawn{
    public ChineseCheckersPawn(int[] coords, double coordx, double coordy){
        super();
        position = coords;
        int pawndiameter = 27;
        shape = new MyShape(coordx, coordy, pawndiameter, pawndiameter);    //ej jak ustawic status na active? xd
    }
    public void scaleThePawn(double scale){}

    public void killThePawn(){

    }
    public void rescueThePawn(){

    }
}
