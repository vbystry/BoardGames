package hwdp;


import java.awt.*;
import java.util.ArrayList;

public abstract class Board {
    protected Shape[][] fields;

    public abstract void generateBoard();

    /*public Shape getPossibleMoves(Pawn p, int moveno){
        return new ArrayList<Shape>;
    }*/
    public abstract void setPawns(ArrayList<Pawn> pawns, int playeram);



    public abstract double convertCoordX(int x, int y);

    public abstract double convertCoordY(int y);
}
