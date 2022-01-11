package hwdp;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public abstract class Game {
    Board board;
    ArrayList<Pawn> pawns;
    ArrayList<Field> actualPossibleMoves;
    Pawn activePawn;

    Game(int playerAm){
        createPawns(2);
        createBoard();
    }

    protected abstract void Round();

    protected abstract void Queue(int PlayerNo);



    protected abstract void createPawns(int numofplayers);

    protected abstract void createBoard();

    protected abstract int HandleClickInfo(MouseEvent e, int playerNo);

    protected abstract void movePawn(Pawn P, int[] position);

    public static double[] covertCoords(int[] coords, String type){ //chyba tez to lepiej wywalic (jak enum)
        return new double[0];
    }
}
