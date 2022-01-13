package hwdp;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    public JPanel panel;
    public int turnflag;
    public Shape[][] board;
    public Shape[][] todraw;
    public GameFrame(String title){
        super(title);
        setSize(1300, 900);
        panel = new JPanel();

        setDefaultCloseOperation(3);
        setVisible(true);
    }
}
