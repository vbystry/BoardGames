package hwdp;

import java.awt.*;
import java.util.ArrayList;

public class Field {
    public Shape shape;
    public ArrayList<Pawn> pawns;
    public Field(double x, double y, double width, double height){
        this.shape = new MyShape(x, y, width, height);

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
