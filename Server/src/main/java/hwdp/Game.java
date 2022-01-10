package hwdp;

import java.awt.*;
import java.util.ArrayList;

public abstract class Game {
    Board board;
    ArrayList<Pawn> pawns;
    ArrayList<Shape> actualPossibleMoves;

    protected abstract void Round();

    protected abstract void Queue(int PlayersNo);

    protected abstract ArrayList<Pawn> createPawns();

    protected abstract Board createBoard();

    public static double[] covertCoords(int[] coords, String type){ //chyba tez to lepiej wywalic (jak enum)
        return new double[0];
    }
}
