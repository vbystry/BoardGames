package hwdp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

public class GamePanel extends JPanel {
    public int turnflag;
    public Shape[][] board;
    public Shape[][] todraw;

    public GamePanel(){

    }
    public Shape[][] readBoardFromBuffer(){


        return null;
    }
    public Shape[][] readToDrawFromBuffer(){

        return null;
    }
    private void drawGame(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(new Color(20,50,70));
        Rectangle2D rec = new Rectangle2D.Double(100,100,20,50);
        g2d.fill(rec);


    }
    public void sendClickInfo(MouseEvent e){

    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        drawGame(g);

    }

}
