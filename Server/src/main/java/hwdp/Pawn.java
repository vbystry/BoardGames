package hwdp;

import java.awt.*;

public abstract class Pawn {
    protected int[] position;
    protected Shape shape;
    protected int[][] possibleMoves;
    protected int playerNo;

    public void move(int[] position){
        this.position=position;
    }

    public void scale(double scale){
    }

    public int[] getPosition(){
        return this.position;
    }

    public int getPlayerNo(){
        return playerNo;
    }


}
