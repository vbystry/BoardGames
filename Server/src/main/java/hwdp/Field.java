package hwdp;

import java.awt.*;
import java.util.ArrayList;

public abstract class Field {
    protected Shape shape;
    protected ArrayList<Pawn> pawns;
    protected enum status{}

    public abstract Shape getShape();

    public abstract void addPawn(Pawn pawntoadd);

    public abstract void removePawn(Pawn pawntomremove);

    public abstract ArrayList<Pawn> getPawns();

}
