package hwdp;

import java.awt.*;
import java.util.ArrayList;

public abstract class Field {
    protected Shape shape;
    protected ArrayList<Pawn> pawns;
    protected enum status{}
    protected int[] position;

    Field(Shape shape, int[] position){
        this.shape=shape;
        this.position=position;
    }

    public abstract Shape getShape();

    public abstract void addPawn(Pawn pawntoadd);

    public abstract void removePawn(Pawn pawntomremove);

    public abstract ArrayList<Pawn> getPawns();

    public int[] getPosition(){
        return position;
    }

}
