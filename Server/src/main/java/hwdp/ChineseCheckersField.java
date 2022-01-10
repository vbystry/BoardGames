package hwdp;

import java.awt.*;
import java.util.ArrayList;

public class ChineseCheckersField extends Field{


    ChineseCheckersField(Shape shape, int[] position) {
        super(shape, position);
    }

    @Override
    public Shape getShape() {
        return this.shape;
    }

    @Override
    public void addPawn(Pawn pawntoadd) {
        pawns.add(pawntoadd);

    }

    @Override
    public void removePawn(Pawn pawntomremove) {
        pawns.remove(pawntomremove);

    }

    @Override
    public ArrayList<Pawn> getPawns() {
        return this.pawns;
    }
}
