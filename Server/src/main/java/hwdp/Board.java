package hwdp;


import java.awt.*;
import java.util.ArrayList;

/**
 * Abstrakcyjna klasa reprezentujaca dowolna plansze do gry
 */
public abstract class Board {
    /**
     * tablica pol znajdujacych sie na planszy (ta struktura danych oferuje najszybszy dostep do przechowywanych pol co zapewnia optymalizajce dzialania gry
     */
    protected Field[][] fields;

    /**
     * konstruktor planszy wywolujacy metode inicjalizacyjna
     */
    Board(){
        generateBoard();
    }

    /**
     * meotoda inicjalizacyjna odpowiadajaca za stworzenie oraz przyporzadkowanie pol planszy
     */
    public abstract void generateBoard();       //tu

    /*public Shape getPossibleMoves(Pawn p, int moveno){
        return new ArrayList<Shape>;
    }*/
    public abstract void setPawns(ArrayList<Pawn> pawns);

    public abstract ArrayList<Field> getPossibleMoves(Pawn pawn, int moveNo);



    public abstract double convertCoordX(int x, int y);

    public abstract double convertCoordY(int y);
}
