package hwdp;

import java.awt.*;

public abstract class Pawn {
    public int [] position;
    public enum status{
        ACTIVE(),
        DEAD();
    }
    public Shape shape;
    public int[] possiblemoves;
    public Board asbtractboard;

    public void moveThePawn(int[] vector){

    }

    public void scaleThePawn(double scale){

    }

    public void killThePawn(){

    }
    public void rescueThePawn(){

    }

}
