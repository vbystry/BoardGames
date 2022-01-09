package hwdp;

import java.awt.*;

public abstract class Pawn {
    protected int[] position;
    protected Shape shape;
    protected int[][] possibleMoves;

    public void move(int[] position){
        this.position=position;
    }

    public void scale(double scale){
        return;
    }


}
