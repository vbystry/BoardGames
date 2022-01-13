package hwdp;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    public JPanel panel;
    public int turnflag;
    public Shape[][] board;
    public Shape[][] todraw;
    public GameFrame(){
        setSize(1300, 1150);
        setDefaultCloseOperation(3);
        setVisible(true);
    }
}
