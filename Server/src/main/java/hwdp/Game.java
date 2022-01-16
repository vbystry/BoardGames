package hwdp;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Abstrakcyjna klasa reprezentujaca dowolna gre planszowa
 */
public abstract class Game implements Runnable{
    /**
     * plansza, na ktore prowadzona jest rozgrywka
     */
    Board board;
    /**
     * lista graczy bioraca udzial w rozgrywce
     */
    ArrayList<Player> players;
    /**
     * lista pionkow
     */
    ArrayList<Pawn> pawns;
    /**
     * lista pol, na ktore moze przemiescic sie pionek
     */
    ArrayList<Field> actualPossibleMoves;// = new ArrayList<>();
    /**
     * pionek bioracy w danej chwili udzial w rozgrywce
     */
    Pawn activePawn;
    /**
     * liczba graczy
     */
    int playerAm;
    //private Jsonb jsonb = JsonbBuilder.create();

    Game(int playerAm){
        //this.pawns= new ArrayList<Pawn>();
        //this.playerAm=playerAm;
        //this.createPawns(playerAm);
        //this.createBoard();
        //this.players = new ArrayList<Player>();

        //while(this.players.size()<playerAm) {}


    }

    public abstract void addPlayer(Player player);  //tu

    protected abstract int Round();

    protected abstract int Queue(int PlayerNo);

    protected ArrayList<Shape> getPlayerData(){
        ArrayList<Shape> data = new ArrayList<Shape>();
        for(Pawn pawn : pawns){
            data.add(pawn.shape);
        }
        if(this.actualPossibleMoves.size()>0)
        {
            for(Field possibleMove : actualPossibleMoves){
                data.add(possibleMove.getShape());
            }
        }

        return data;
    }

    protected abstract void createPawns(int numofplayers);

    protected abstract void createBoard();

    protected abstract int HandleClickInfo(Object[] info, int playerNo);

    protected abstract void movePawn(Pawn P, int[] position);

    public static double[] covertCoords(int[] coords, String type){ //chyba tez to lepiej wywalic (jak enum)
        return new double[0];
    }

    @Override
    public void run(){}
}
