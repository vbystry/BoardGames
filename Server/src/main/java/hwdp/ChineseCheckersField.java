package hwdp;

import java.awt.*;
import java.util.ArrayList;

public class ChineseCheckersField extends Field{
    @Override
    public Shape getShape() {
        return null;
    }

    @Override
    public void addPawn(Pawn pawntoadd) {

    }

    @Override
    public void removePawn(Pawn pawntomremove) {

    }

    @Override
    public ArrayList<Pawn> getPawns() {
        return this.pawns;
    }
}
