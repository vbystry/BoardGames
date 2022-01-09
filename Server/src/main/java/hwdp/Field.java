package hwdp;

import java.awt.*;
import java.util.ArrayList;

public abstract class Field {
    public Shape shape;
    public ArrayList<Pawn> pawns;
    public enum status {
        LIGHTED(),
        DIMMED();
    }

    public Shape getShape(){
        return this.shape;
    }

    public void addPawn(Pawn pawntoadd){
        pawns.add(pawntoadd);
    }

    public void removePawn(Pawn pawntomremove){
        pawns.remove(pawntomremove);
    }
}
