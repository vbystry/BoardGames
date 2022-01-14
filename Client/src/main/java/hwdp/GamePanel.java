package hwdp;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class GamePanel extends JPanel implements Runnable {
    private boolean turnflag = false;
    private boolean gameOver = false;
    public ArrayList<Shape> board= new ArrayList<>();
    public ArrayList<Shape> todraw = new ArrayList<>();
    private Scanner in;
    private PrintWriter out;
    private Scanner scanner;
    private Jsonb jsonb = JsonbBuilder.create();

    public GamePanel(Scanner in, PrintWriter out){
        this.in=in;
        this.out=out;

        String data="";

        while(true) {

            while (!in.hasNextLine()) {

            }
            data = in.nextLine();
            if(data.equals("end"))  {break;}
            //board=jsonb.fromJson(data, new ArrayList<Shape>(){}.getClass().getGenericSuperclass());
            board.add(App.decodeFigure(data));
        }

        myMouseAdapter A= new myMouseAdapter();
        addMouseListener(A);
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
        //Rectangle2D rec = new Rectangle2D.Double(100,100,20,50);
        //g2d.fill(rec);

        for(Shape shape : board)
        {
            g2d.fill(shape);
        }
        for(Shape shape : board){
            g2d.fill(shape);
        }


        //for(Shape shape : todraw)
        //{
        //    g2d.fill(shape);
        //}


    }
    public void sendClickInfo(MouseEvent e){
        if(turnflag)
        {
            String event = jsonb.toJson(e);
            out.println(event);
            System.out.println(event);
        }
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        drawGame(g);

    }




    private class myMouseAdapter extends MouseAdapter{
        @Override
        public void mousePressed(MouseEvent event){
            sendClickInfo(event);
        }
    }

    @Override
    public void run() {
        while(!gameOver)
        {
            if(in.hasNextLine()){
                String data = in.nextLine();
                //String data2= in.nextLine();
                System.out.println(data);


                if(data.equals("Your turn"))        {this.turnflag=true;}
                else if(data.equals("Turn over"))   {this.turnflag=false;}
                else
                {
                    System.out.println(data);
                    //System.out.println(data2);
                    //todraw = jsonb.fromJson(data, new ArrayList<Shape>(){}.getClass().getGenericSuperclass());
                }
            }

        }
    }
}
