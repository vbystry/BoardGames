package hwdp;

import java.awt.*;

/**
 * Abstrakcyjna klasa reprezentujaca pionka w dowolnej grze
 */
public abstract class Pawn {
    /**
     * tablica wspolrzednych pozycji w planszy (raczej zawsze dwuelementowa, chyba ze stworzymy jakas gre w wiekszej ilosci wymairow)
     */
    protected int[] position;
    /**
     * ksztalt, jaki przyjmie pionek
     */
    protected Shape shape;
    /**
     *
     */
    protected int[][] possibleMoves;
    /**
     * numer gracza, ktory obsluguje danego pionka
     */
    protected int playerNo;

    /**
     * metoda przemieszczajaca pionka
     * @param position  polozenie pionka w tablicy pol
     */
    public void move(int[] position){
        this.position=position.clone();
    }

    /**
     * skalowanie pionka
     * @param scale wspolczynnik skali
     */
    public void scale(double scale){
    }

    /**
     * publiczna metoda zwracajaca biezaca pozycje pionka
     * @return
     */
    public int[] getPosition(){
        return this.position;
    }

    /**
     * publiczna metoda zwracajaca numer gracza odpowiedzialnego za obsluge pionka
     * @return
     */
    public int getPlayerNo(){
        return playerNo;
    }


}
