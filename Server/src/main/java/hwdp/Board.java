package hwdp;


import java.awt.*;
import java.util.ArrayList;

/**
 * Abstrakcyjna klasa reprezentujaca dowolna plansze do gry
 * @author Mateusz Bystronski
 * @author Piotr Korycki
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

    /**
     * metoda zwrcajaca liste mozliwych ruchow
     * @param pawn pionek
     * @param moveNo numer ruchu
     * @return lista wolnych pol
     */
    public abstract ArrayList<Field> getPossibleMoves(Pawn pawn, int moveNo);


    /**
     * konwersja wspolrzednej x z macierzy w panel
     * @param x x
     * @param y y
     * @return x jako wspolrzedna w panelu
     */
    public abstract double convertCoordX(int x, int y);
    /**
     * konwersja wspolrzednej x z macierzy w panel
     * @param y y
     * @return y jako wspolrzedna w panelu
     */
    public abstract double convertCoordY(int y);
}
