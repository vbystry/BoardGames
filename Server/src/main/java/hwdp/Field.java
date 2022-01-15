package hwdp;

import java.awt.*;
import java.util.ArrayList;

/**
 * klasa abstrakcyjna opisujaca pole w dowolnej grze planszowej
 */
public abstract class Field {
    /**
     * ksztalt, ktory przyjmuje budowane pole
     */
    protected Shape shape;
    /**
     * lista pionkow, znajdujacych sie obecnie na polu (dynamiczna struktura danych zapewnia nieograniczona ilosc pionkow, co okaze sie przydatne w innych grach planszowych)
     */
    protected ArrayList<Pawn> pawns;
    /**
     * tablica wspolrzednych pozycji w planszy (raczej zawsze dwuelementowa, chyba ze stworzymy jakas gre w wiekszej ilosci wymiarow)
     */
    protected int[] position;

    /**
     * konstruktor nowego pola, przyporzadkowuje mu potrzebne polozenie, ksztalt oraz inicjuje liste pionkow
     * @param shape
     * @param position
     */
    Field(Shape shape, int[] position){
        this.shape=shape;
        this.position=position;
        this.pawns= new ArrayList<Pawn>();
    }

    /**
     * metoda zwracajaca ksztalt pola
     * @return
     */
    public abstract Shape getShape();

    /**
     * metoda dodajaca nowego pionka do listy pionkow ustawionych na polu
     * @param pawntoadd
     */
    public abstract void addPawn(Pawn pawntoadd);

    /**
     * meoda usuwajaca pionek z pola (przydatna chocby w szachach przy biciu pionka)
     * @param pawntomremove
     */
    public abstract void removePawn(Pawn pawntomremove);

    /**
     * metoda zwracajaca wszystkie pionki polozone na polu
     * @return
     */
    public abstract ArrayList<Pawn> getPawns();

    /**
     * metoda zwracajaca polozenie pola
     * @return
     */
    public int[] getPosition(){
        return position;
    }

}
