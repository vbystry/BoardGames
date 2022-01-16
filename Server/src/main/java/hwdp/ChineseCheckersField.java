package hwdp;

import java.awt.*;
import java.util.ArrayList;

/**
 * Klasa odpowiadajaca za rozszerzenie pola
 */
public class ChineseCheckersField extends Field{


    /**
     * Konstruktor dziedziczacy po klasie abstrakcyjnej
     * @param shape
     * @param position
     */
    ChineseCheckersField(Shape shape, int[] position) {
        super(shape, position);
    }

    /**
     * Metoda zwracajaca ksztalt pola
     * @return
     */
    @Override
    public Shape getShape() {
        return this.shape;
    }

    /**
     * metoda dodajace pionka do listy pionkow poloznych na danym polu
     * @param pawntoadd
     */
    @Override
    public void addPawn(Pawn pawntoadd) {
        pawns.add(pawntoadd);

    }

    /**
     * metoda usuwajaca pionka z listy pionkow poloznych na danym polu
     * @param pawntomremove
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
