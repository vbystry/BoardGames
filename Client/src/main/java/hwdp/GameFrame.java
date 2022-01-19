package hwdp;

import javax.swing.*;
import java.awt.*;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * klasa okna, w kotrym odbywa sie rozgrywka
 * @author  Piotr Korycki
 * @author  Mateusz Bystronski
 */
public class GameFrame extends JFrame {
    /**
     * panel, na ktorym odbywa sie rozgrywka
     */
    protected JPanel panel;

    /**
     * konstruktor okna, tworzy panel obslugi rozrywki oraz watek, w ktorym odbywa sie rozgrywka
     * @param title nazwa wybranej gry
     * @param in standardowe wejscie okna gry
     * @param out standardowe wyjscie okna gry
     */
    public GameFrame(String title, Scanner in,PrintWriter out){

        super(title);
        setVisible(true);
        setSize(1300, 900);
        panel = new GamePanel(in, out, title);
        add(panel);
        new Thread((Runnable) panel).start();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
