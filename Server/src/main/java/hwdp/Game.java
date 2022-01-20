package hwdp;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Abstrakcyjna klasa reprezentujaca dowolna gre planszowa
 * @author  Mateusz Bystronski
 * @author Piotr Korycki
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

    /**
     * konstruktor
     * @param playerAm liczba graczy
     */
    Game(int playerAm){
        //this.pawns= new ArrayList<Pawn>();
        //this.playerAm=playerAm;
        //this.createPawns(playerAm);
        //this.createBoard();
        //this.players = new ArrayList<Player>();

        //while(this.players.size()<playerAm) {}


    }

    /**
     * metoda dodajaca gracza
     * @param player obiekt watku gracza
     */
    public abstract void addPlayer(Player player);  //tu

    /**
     * metoda wykonania rundy
     * @return 1 by kontynuowac rogrywke
     */
    protected abstract int Round();

    /**
     * metoda kolejkujaca graczy
     * @param PlayerNo numer gracza
     * @return 1 by kontynuowac
     */
    protected abstract int Queue(int PlayerNo);

    /**
     * metoda pobierajaca pionki oraz mozliwe ruchy dla danego gracza
     * @return lista figur
     */
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

    /**
     * metoda tworzaca uklad pionow wraz z ich potrzebnymi atrybutami
     * @param numofplayers liczba graczy
     */
    protected abstract void createPawns(int numofplayers);

    /**
     * metoda inicjalizujaca powstanie planszy
     */
    protected abstract void createBoard();

    /**
     * metoda obslugujaca sygnal o uzyciu kursora
     * @param info tablica informacji z serwera
     * @param playerNo numer gracza
     * @return 1 w celu kontynuowania kolejki, 0 w celu jej zakonczenia
     */
    protected abstract int HandleClickInfo(Object[] info, int playerNo);

    /**
     * metoda zmieniajaca pozycje pionka na docelowa
     * @param P
     * @param position
     */
    protected abstract void movePawn(Pawn P, int[] position);

    /**
     * metoda statyczna przeksztlcajaca tablice wspolrzednych w macierzy we wspolrzedne panelu
     * @param coords wspolrzedne wejsciowe
     * @param type typ elementu, dla ktorego dokonujemy konwersji
     * @return wspolrzedne panelu
     */
    public static double[] covertCoords(int[] coords, String type){ //chyba tez to lepiej wywalic (jak enum)
        return new double[0];
    }

    /**
     * metoda uruchamiajaca watki graczy
     */
    @Override
    public void run(){}
}
