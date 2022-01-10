package hwdp;


import java.awt.*;
import java.util.ArrayList;

public abstract class Board {
    protected Field[][] fields;

    public abstract void generateBoard();

    /*public Shape getPossibleMoves(Pawn p, int moveno){
        return new ArrayList<Shape>;
    }*/
    public abstract void setPawns(ArrayList<Pawn> pawns);

    public abstract ArrayList<Field> getPossibleMoves(Pawn pawn);



    public abstract double convertCoordX(int x, int y);

    public abstract double convertCoordY(int y);
}
