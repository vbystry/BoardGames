package hwdp;

import java.awt.*;
import java.util.ArrayList;

/**
 * Klasa odpowiadajaca za rozszerzenie pola
 */
public class ChineseCheckersField extends Field{


    /**
     * Konstruktor dziedziczacy po klasie abstrakcyjnej
     * @param shape ksztalt pola
     * @param position miejsce pola w strukturze danych planszy
     */
    ChineseCheckersField(Shape shape, int[] position) {
        super(shape, position);
    }

    /**
     * Metoda zwracajaca ksztalt pola
     * @return ksztalt pola
     */
    @Override
    public Shape getShape() {
        return this.shape;
    }

    /**
     * metoda dodajace pionka do listy pionkow poloznych na danym polu
     * @param pawntoadd pionek, ktorego chcemy dodac do listy
     */
    @Override
    public void addPawn(Pawn pawntoadd) {
        pawns.add(pawntoadd);

    }

    /**
     * metoda usuwajaca pionka z listy pionkow poloznych na danym polu
     * @param pawntomremove pionek, ktorego chcemy usunac z lity
     */
    @Override
    public void removePawn(Pawn pawntomremove) {
        pawns.remove(pawntomremove);

    }

    /**
     *     metoda dajaca dostep do listy pionkow znajdujacych sie na podanym polu
     */
    @Override
    public ArrayList<Pawn> getPawns() {
        return this.pawns;
    }
}
