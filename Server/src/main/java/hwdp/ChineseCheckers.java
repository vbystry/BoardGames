package hwdp;

import java.util.ArrayList;

public class ChineseCheckers extends Game{

    private static final double initx = 130;
    private static final double inity = 10;
    private static double ix, iy;
    final static private int mycdiameter = 50;
    final static private int standarddis = 10;

    @Override
    protected void Round() {

    }

    @Override
    protected void Queue(int PlayersNo) {

    }

    @Override
    protected ArrayList<Pawn> createPawns() {
        return null;
    }

    @Override
    protected Board createBoard() {
        return null;
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
