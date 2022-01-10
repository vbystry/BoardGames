package hwdp;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ChineseCheckers extends Game{

    private static final double initx = 130;
    private static final double inity = 10;
    private static double ix, iy;
    final static private int mycdiameter = 50;
    final static private int standarddis = 10;

    ChineseCheckers(int playerAm){      //nie wiem czy tu nie bedzie problem, tzn czy w super beda sie wywolwyaly metody nadpisane czy nie
        super(playerAm);
    }

    @Override
    protected void Round() {

    }

    @Override
    protected void Queue(int PlayerNo) {
        int queueFlag=1;
        while(queueFlag>0)
        {
            //oczekiwanie i pobieranie e od klienta
            //MouseEvent e = new MouseEvent();
            //queueFlag=HandleClickInfo(e, PlayerNo);
        }
    }

    @Override
    protected void createPawns() {
    }

    @Override
    protected void createBoard() {
        this.board = new ChineseCheckersBoard();
        this.board.setPawns(pawns);
    }

    @Override
    protected int HandleClickInfo(MouseEvent e, int playerNo) {   //1- kontynuujemy runde, 0- koniec
        if(activePawn != null)
        {
            if(activePawn.shape.contains(e.getPoint()))
            {
                return 0;
            }
            else
            {
                for(Field possibleMove : actualPossibleMoves) {
                    if (possibleMove.shape.contains(e.getPoint())) {
                        movePawn(activePawn, possibleMove.getPosition());
                        return 1;
                    }
                }
            }

        }
        else
        {
            for(Pawn P : pawns)
            {
                if (P.shape.contains(e.getPoint()) && P.getPlayerNo() == playerNo) {
                    activePawn = P;
                    return 1;
                }
            }
        }
        return 1;
    }

    @Override
    protected void movePawn(Pawn P, int[] position) {
        P.move(position);
    }


    public static double[] covertCoords(int[] coords, String type) {
        if(type.equals("Pawn"))
        {
            return pawnCoordsConv(coords);
        }
        else if(type.equals("Field"))
        {
            return fieldCoordsConv(coords);
        }
        else
        {
            return new double[0];
        }
    }

    private static double[] pawnCoordsConv(int[] coords){
        double[] converted = new double[2];

        if(coords[2] % 2 == 0){
            converted[1] = initx + (coords[0]/2) * (mycdiameter + standarddis)+3;   //zmienic +3 XD dalem losowo
        } else {
            converted[1] = initx - ((mycdiameter + standarddis) / 2) + (coords[0]/2) * (mycdiameter + standarddis)+3;
        }

        /* Czy nie lepiej tak:
         * if(type.equals("Pawn") {converted[1]+=3;}
         */

        converted[0] = inity + coords[1] * mycdiameter +3;

        return converted;
    }

    public static double[] fieldCoordsConv(int[] coords){
        double[] converted = new double[2];

        if(coords[2] % 2 == 0){
            converted[0] = initx + (coords[0]/2) * (mycdiameter + standarddis);
        } else {
            converted[0] = initx - ((mycdiameter + standarddis) / 2) + (coords[0]/2) * (mycdiameter + standarddis);
        }

        converted[1] = inity + coords[1] * mycdiameter;

        return converted;
    }
}
