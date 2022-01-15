package hwdp;

import javax.swing.*;
import java.awt.*;
import java.io.PrintWriter;
import java.util.Scanner;

public class GameFrame extends JFrame {
    protected JPanel panel;


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
