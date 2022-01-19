package hwdp;

import java.awt.*;
import java.util.ArrayList;

/**
 * klasa abstrakcyjna opisujaca pole w dowolnej grze planszowej
 * @author Mateusz Bystronski
 * @author Piotr Korycki
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
     * @param shape ksztalt pola
     * @param position miejsce pola w strukturze danych planszy
     */
    Field(Shape shape, int[] position){
        this.shape=shape;
        this.position=position;
        this.pawns= new ArrayList<Pawn>();
    }

    /**
     * metoda zwracajaca ksztalt pola
     * @return ksztalt pola
     */
    public abstract Shape getShape();

    /**
     * metoda dodajaca nowego pionka do listy pionkow ustawionych na polu
     * @param pawntoadd pionek, ktorego chcemy dodac do listy
     */
    public abstract void addPawn(Pawn pawntoadd);

    /**
     * meoda usuwajaca pionek z pola (przydatna chocby w szachach przy biciu pionka)
     * @param pawntomremove pionek, ktorego chcemy usunac z listy
     */
    public abstract void removePawn(Pawn pawntomremove);

    /**
     * metoda zwracajaca wszystkie pionki polozone na polu
     * @return lista pionkow
     */
    public abstract ArrayList<Pawn> getPawns();

    /**
     * metoda zwracajaca polozenie pola
     * @return wektor polozenia wzgledem lewego gornego rogu
     */
    public int[] getPosition(){
        return position;
    }

}
